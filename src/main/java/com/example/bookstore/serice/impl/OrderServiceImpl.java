package com.example.bookstore.serice.impl;

import com.example.bookstore.model.entity.OrderEntity;
import com.example.bookstore.model.entity.OrderItemEntity;
import com.example.bookstore.model.entity.UserEntity;
import com.example.bookstore.model.entity.enums.OrderStatusEnum;
import com.example.bookstore.model.view.CartItemViewModel;
import com.example.bookstore.model.view.OrderViewModel;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.repository.OrderItemRepository;
import com.example.bookstore.repository.OrderRepository;
import com.example.bookstore.repository.UserRepository;
import com.example.bookstore.serice.OrderService;
import com.example.bookstore.serice.ShoppingCartService;
import com.example.bookstore.serice.UserService;
import com.example.bookstore.util.DataUtils;
import com.example.bookstore.web.exception.InvalidOrderException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.bookstore.web.exception.ObjectNotFoundException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import static com.example.bookstore.constant.GlobalConstants.*;
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final UserService userService;
    private final OrderItemRepository orderItemRepository;
    private final ShoppingCartService shoppingCartService;
    private final ModelMapper modelMapper;

    public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository, BookRepository bookRepository, UserService userService, OrderItemRepository orderItemRepository, ShoppingCartService shoppingCartService, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.userService = userService;
        this.orderItemRepository = orderItemRepository;
        this.shoppingCartService = shoppingCartService;
        this.modelMapper = modelMapper;
    }

    @Transactional
    @Override
    public List<OrderViewModel> findAllOrders() {
        return orderRepository
                .findAllByOrderTimeDesc()
                .stream()
                .map(this::getOrderViewModel)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public List<OrderViewModel> findAllOrdersByCustomer(String username) {
        return orderRepository
                .findAllByCustomerUsernameOrderByOrderTimeDesc(username)
                .stream()
                .map(this::getOrderViewModel)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public List<OrderViewModel> findLastFiveOrdersByCustomer(String username) {
        return orderRepository
                .findTop5ByCustomerUsernameOrderByOrderTimeDesc(username)
                .stream()
                .map(this::getOrderViewModel)
                .collect(Collectors.toList());
    }

    @Override
    public Long createOrder(String username) {

        List<CartItemViewModel> itemViewModels = shoppingCartService
                .getCartItemsByCustomer(username);

        if(itemViewModels.size() == 0){
            throw new InvalidOrderException(EMPTY_ORDER_ERROR_MESSAGE);
        }

        BigDecimal totalPrice = itemViewModels
                .stream()
                .map(CartItemViewModel::calculatePrice)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.valueOf(0));

        OrderEntity orderEntity = new OrderEntity()
                .setOrderTime(LocalDateTime.now())
                .setPrice(totalPrice)
                .setStatus(OrderStatusEnum.ORDERED)
                .setCustomer(getUserEntity(username));

        OrderEntity newOrder = orderRepository.save(orderEntity);

        itemViewModels.stream()
                .map(this::getOrderItemEntity)
                .map(orderItemEntity -> orderItemEntity.setOrder(newOrder))
                .forEach(orderItemRepository::save);
        return null;
    }

    @Override
    public Optional<OrderViewModel> findById(Long id) {
        return orderRepository.findById(id)
                .map(this::getOrderViewModel);
    }

    @Override
    public Boolean isOwner(String userName, Long id) {
        Optional<UserEntity> userEntityOptional = userRepository
                .findByUsername(userName);

        Optional<OrderEntity> optionalOrderEntity = orderRepository
                .findById(id);

        if(userEntityOptional.isEmpty() || optionalOrderEntity.isEmpty()){
            return false;
        } else {
            OrderEntity orderEntity = optionalOrderEntity.get();

            return userService.isAdmin(userEntityOptional.get().getUsername())
            || orderEntity.getCustomer().getUsername().equals(userName);
        }

    }


    private UserEntity getUserEntity(String username) {
        return userRepository
                .findByUsername(username)
                .orElseThrow(() -> new ObjectNotFoundException(OBJECT_NAME_USER));
    }

    private OrderViewModel getOrderViewModel(OrderEntity orderEntity){
        return modelMapper.map(orderEntity, OrderViewModel.class)
                .setCustomerFullName(DataUtils.getFullName(
                        orderEntity.getCustomer().getFirstName()
                , orderEntity.getCustomer().getLastName()));
    }

    private OrderItemEntity getOrderItemEntity(CartItemViewModel cartItem){
        return new OrderItemEntity()
                .setQuantity(cartItem.getQuantity())
                .setBook(bookRepository.findByIdAndActiveTrue(cartItem.getBook().getId())
                        .orElseThrow(() -> new ObjectNotFoundException(OBJECT_NAME_USER)));
    }
}

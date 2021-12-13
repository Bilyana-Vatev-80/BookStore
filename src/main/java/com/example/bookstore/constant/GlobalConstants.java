package com.example.bookstore.constant;

public class GlobalConstants {

    public static final String DEFAULT_BOOK_IMAGE_URL = "/images/default-book-cover.png";

    public static final String DEFAULT_AUTHOR_IMAGE_URL = "/images/default-author-pic.png";

    public static final String OBJECT_NAME_BOOK = "book";
    public static final String OBJECT_NAME_AUTHOR = "author";
    public static final String OBJECT_NAME_PUBLISHING_HOUSE = "publishing house";
    public static final String OBJECT_NAME_CATEGORY = "category";
    public static final String OBJECT_NAME_USER = "user";
    public static final String OBJECT_NAME_USER_ROLE = "user role";
    public static final String OBJECT_NAME_ORDER = "order";
    public static final String OBJECT_NAME_CART_ITEM = "cart item";
    public static final String OBJECT_NAME_WISHLIST_ITEM = "wishlist item";
    public static final String OBJECT_NAME_REVIEW = "review";

    public static final String TEMP_FILE = "temp-file";
    public static final String URL = "url";
    public static final String PUBLIC_ID = "public_id";

    public static final String ORDER_STATS_URI = "/orders/create";
    public static final String VIEWS_COUNT_URI = "/books/%s";


    public static final String USERNAME_NOT_FOUND_ERROR_MESSAGE = "User with name %s not found!";

    public static final String EMPTY_ORDER_ERROR_MESSAGE =
            "We are really sorry, the selected books are no longer available for purchase. Please browse the books on our homepage.";

    public static final String CANNOT_UPDATE_ORDER_STATUS_ERROR_MESSAGE =
            "Sorry, order cannot be proceeded because books are either no longer available for purchase or order has already been delivered. " +
                    "Changing order status is not a valid operation.";
}

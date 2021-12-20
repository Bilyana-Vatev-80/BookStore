package com.example.bookstore.model.view;

public class RequestStatsView {

    private int authenticatedRequests;
    private int anonymousRequests;

    public RequestStatsView(int authenticatedRequests, int anonymousRequests) {
        this.authenticatedRequests = authenticatedRequests;
        this.anonymousRequests = anonymousRequests;
    }

    public int getTotalRequests(){
        return authenticatedRequests + anonymousRequests;
    }

    public int getAuthenticatedRequests() {
        return authenticatedRequests;
    }

    public int getAnonymousRequests() {
        return anonymousRequests;
    }
}

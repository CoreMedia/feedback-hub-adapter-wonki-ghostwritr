package com.coremedia.labs.plugins.feedbackhub.wonky.adapter;

import com.coremedia.feedbackhub.adapter.FeedbackContext;
import com.coremedia.feedbackhub.items.FeedbackItem;
import com.coremedia.feedbackhub.items.FeedbackItemFactory;
import com.coremedia.feedbackhub.items.FeedbackLinkFeedbackItem;
import com.coremedia.feedbackhub.provider.FeedbackProvider;
import com.coremedia.labs.plugins.feedbackhub.wonky.custom.items.GhostWritrDetailsFeedbackItem;
import com.coremedia.labs.plugins.feedbackhub.wonky.custom.items.GhostWritrGeneralFeedbackItem;
import edu.umd.cs.findbugs.annotations.DefaultAnnotation;
import edu.umd.cs.findbugs.annotations.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static com.coremedia.labs.plugins.feedbackhub.wonky.WonkyGhostWritrFeedbackCollections.DETAILS;
import static com.coremedia.labs.plugins.feedbackhub.wonky.WonkyGhostWritrFeedbackCollections.GENERAL;

/**
 *
 */
@DefaultAnnotation(NonNull.class)
public class WonkyGhostwriterFeedbackProvider implements FeedbackProvider {

  @Override
  public CompletionStage<Collection<FeedbackItem>> provideFeedback(FeedbackContext context) {
    List<FeedbackItem> items = new ArrayList<>();

    FeedbackLinkFeedbackItem wonkyLink = FeedbackItemFactory.createFeedbackLink("https://github.com/CoreMedia/feedback-hub-adapter-wonky-ghostwritr");
    items.add(wonkyLink);

    GhostWritrGeneralFeedbackItem ghostWritrGeneralFeedbackItem = GhostWritrGeneralFeedbackItem.builder()
            .withCollection(GENERAL)
            .build();
    items.add(ghostWritrGeneralFeedbackItem);

    GhostWritrDetailsFeedbackItem ghostWritrDetailsFeedbackItem = GhostWritrDetailsFeedbackItem.builder()
            .withCollection(DETAILS)
            .build();
    items.add(ghostWritrDetailsFeedbackItem);

    return CompletableFuture.completedFuture(items);
  }
}
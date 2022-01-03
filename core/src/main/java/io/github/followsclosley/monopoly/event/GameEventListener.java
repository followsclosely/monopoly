package io.github.followsclosley.monopoly.event;

public interface GameEventListener<T extends GameChangedEvent> {
    void onEvent(T e);
}

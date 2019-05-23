package br.com.academy.helpers;

import com.google.gson.JsonObject;
import rx.Observable;
import rx.subjects.PublishSubject;

public class GenericPublish {

    public GenericPublish() {
    }

    private final PublishSubject<JsonObject> publish = PublishSubject.create();

    public void send(JsonObject o) {
        publish.onNext(o);
    }

    public Observable<JsonObject> toObservable() {
        return publish;
    }
}

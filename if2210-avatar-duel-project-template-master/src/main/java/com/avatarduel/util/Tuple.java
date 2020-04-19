package com.avatarduel.util;

public class Tuple<V,W>{
    private V first;
    private W second;
    public Tuple(V v, W w) {
        this.first = v;
        this.second = w;
    }
    public V getFirst() {
        return this.first;
    }
    public W getSecond() {
        return this.second;
    }
}
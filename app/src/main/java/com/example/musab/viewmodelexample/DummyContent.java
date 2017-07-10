package com.example.musab.viewmodelexample;

import java.util.ArrayList;
import java.util.List;

public class DummyContent {


    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();


    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            ITEMS.add(new DummyItem(String.valueOf(i), "Item " + i, "Details about Item: " + i + "\nMore details information here."));

        }
    }


    public static class DummyItem {
        public final String id;
        public final String content;
        public final String details;

        public DummyItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}

package com.ge.exercise5;

public class Item {
    public enum ItemType {NORMAL, AGEABLE, PRECIOUS, CLIFF}

    public ItemType type;
    public int value;
    public int sellBy;

    public Item(ItemType itemType, int value, int sellBy) {
        this.type = itemType;
        this.value = value;
        this.sellBy = sellBy;
    }

    public ItemType getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getSellBy() {
        return sellBy;
    }

    public void setSellBy(int sellBy) {
        this.sellBy = sellBy;
    }
}

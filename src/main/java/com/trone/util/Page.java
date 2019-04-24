package com.trone.util;

public class Page {
    //开始位置
    private int start = 0;
    //每页的条数
    private int count = 5;
    //最后一页的开始位置
    private int last = 0;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    public void caculateLast(int total) {
        if (0 == total % count) {
            last = total - count;
        } else {
            last = total - total % count;
        }
    }

    @Override
    public String toString() {
        return "Page{" +
                "start=" + start +
                ", count=" + count +
                ", last=" + last +
                '}';
    }
}

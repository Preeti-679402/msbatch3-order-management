package com.sl.ms.ordermanagement.controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

    @Entity
    @Table
    public class SLItems {
        @Id
        @GeneratedValue
        private Long item_id;
        private Long order_id;
        private String name;
        private Integer quantity;
        private Integer price;

        public SLItems(Long item_id, Long order_id, String name, Integer quantity, Integer price) {
            super();
            this.item_id = item_id;
            this.order_id = order_id;
            this.name = name;
            this.quantity = quantity;
            this.price = price;
        }

        public SLItems() {

        }

        public Long getItem_id() {
            return item_id;
        }

        public void setItem_id(Long item_id) {
            this.item_id = item_id;
        }

        public Long getOrder_id() {
            return order_id;
        }

        public void setOrder_id(Long order_id) {
            this.order_id = order_id;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    package com.example.demoapi;

    public class Account {
        private int Id;
        private String name, detail;
        private String password;
        @Override
        public String toString() {
            return name + "--"+ detail;
        }
        public String toStringall() { return Id+":"+name + "--"+ password+ "---"+detail; }
        public Account(int id, String name, String pass, String detail) {
            this.Id = id;
            this.name = name;
            this.password = pass;
            this.detail = detail;
        }
        public int getId() {
            return Id;
        }
        public void setId(int id) {
            this.Id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getPass() {
            return password;
        }
        public void setPass(String pass) {
            this.password = pass;
        }
        public String getDetail() {
            return detail;
        }
        public void setDetail(String detail) {
            this.detail = detail;
        }
    }

package com.example.finaldemo.model;

public class Message {
    private String kinds;
//    private String mcontent;
//    private String mtime;
    public String getMtitle() {
        return kinds;
    }
    public void setMtitle(String mtitle) {
        this.kinds = mtitle;
    }
//    public String getMcontent() {
//        return mcontent;
//    }
//    public void setMcontent(String mcontent) {
//        this.mcontent = mcontent;
//    }
//    public String getMtime() {
//        return mtime;
//    }
//    public void setMtime(String mtime) {
//        this.mtime = mtime;
//    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
//        return mtitle + ":"+ mcontent + "  time:"+mtime;
        return kinds;
    }
}

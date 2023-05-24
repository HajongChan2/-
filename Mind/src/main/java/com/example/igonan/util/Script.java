package com.example.igonan.util;

public class Script {

    //back = 뒤로가기
    public static String back(String msg) {
        StringBuilder sb = new StringBuilder();
        sb.append("<script>");
        sb.append("alert('"+msg+"');");
        sb.append("history.back();");
        sb.append("</script>");
        return sb.toString();
    }
    // href = 지정된 사이트 이동
    public static String tohref(String path) {
        StringBuilder sb = new StringBuilder();
        sb.append("<script>");
        sb.append("location.href='"+path+"';");
        sb.append("</script>");
        return sb.toString();
    }
    public static String href(String path, String msg) {
        StringBuilder sb = new StringBuilder();
        sb.append("<script>");
        sb.append("alert(' " + msg + " ');");
        sb.append("location.href='"+ path +"';");
        sb.append("</script>");
        return sb.toString();
    }
    public static  String reload(String msg){
        StringBuilder sb = new StringBuilder();
        sb.append("<script>");
        sb.append("alert('"+msg+"');");
        sb.append("window.location.reload();");
        sb.append("</script>");
        return sb.toString();
    }
}

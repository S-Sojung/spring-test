package shop.mtcoding.test.util;

//응답을 따로 안하고
//자바스크립트로 경고창을 띄우고 , 히스토리 백을 함 
public class Script {
    public static String back(String msg) {
        StringBuffer sb = new StringBuffer();
        sb.append("<script>");
        sb.append("alert('" + msg + "');");
        sb.append("history.back();");
        sb.append("</script>");

        return sb.toString();
    }

    public static String href(String msg, String path) {
        StringBuffer sb = new StringBuffer();
        sb.append("<script>");
        sb.append("alert('" + msg + "');");
        sb.append("location.href='" + path + "';");
        sb.append("</script>");

        return sb.toString();
    }

    public static String href(String path) {
        StringBuffer sb = new StringBuffer();
        sb.append("<script>");
        sb.append("location.href='" + path + "';");
        sb.append("</script>");

        return sb.toString();
    }
}
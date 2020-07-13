package com.clayun.auto;

import com.clayun.auto.image.Coordinate;
import com.clayun.auto.image.ImageApplication;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) throws AWTException, IOException {

//        add("2-4","D:\\Documents\\Tencent Files\\1627072456\\FileRecv\\2-4.xlsx");

        operate("15810330527","哈哈哈");

    }

    private static void add(String num,String path) throws AWTException, IOException {



        List<ExcelAdd> excelAdds = ExcelReader.readExcel(path);

        for(ExcelAdd excelAdd : excelAdds){
            String mobile = excelAdd.getMobile()+"";
            String beizhu = excelAdd.getName()+"孩子家长"+num;

            System.out.println("开始添加："+mobile+"  "+beizhu);
            operate(mobile,beizhu);
        }
    }

    private static boolean clickButtonByImage(Robot robot,String path,int times) throws IOException, AWTException {
        Coordinate position = ImageApplication.getPosition(path);
        if(position != null){
            for(int i = 0 ;i <= times; i++){
                clickMouse(robot, position.getX(), position.getY(), 300);
            }

            System.out.println("点击 "+path+" 成功");
            return true;
        }
        System.out.println("点击 "+path+" 失败");
        return false;
    }

    private static boolean clickButtonByImageFinalPixel(Robot robot,String path,int times) throws IOException, AWTException {
        Coordinate position = ImageApplication.getFinalPosition(path);
        if(position != null){
            for(int i = 0 ;i < times; i++){
                clickMouse(robot, position.getX(), position.getY(), 300);
            }

            System.out.println("点击 "+path+" 成功");
            return true;
        }

        System.out.println("点击 "+path+" 失败");
        return false;
    }

    private static void operate(String mobile,String beizhu) throws AWTException, IOException {
        Robot robot = new Robot();

        //尝试回到首页
//        clickButtonByImage(robot, "return.png", 3);

        //点击加号
        boolean b2 = clickButtonByImage(robot, "add_button.png", 1);

        if(!b2){
            return;
        }

        //添加朋友按钮
        boolean b3 = clickButtonByImage(robot, "add_friend_button.png", 1);
        if(!b3){
            return;
        }

        //打开输入框
        boolean b4 = clickButtonByImage(robot, "add_friend_textarea.png", 1);
        if(!b4){
            return;
        }

//        setAndctrlVClipboardData2(mobile);
        //输入手机号
        pressNum(robot,mobile,500);

        //搜索
        boolean b = clickButtonByImage(robot, "search_mobile.png", 1);

        if(!b){
            System.out.println("未找到该用户");
            return;
        }

        //发起邀请
        boolean add_contact = clickButtonByImage(robot, "add_contact_button.png", 1);

        if(!add_contact){
            System.out.println("该用户已添加过，无需重复");
            return;
        }

        //点击设置备注
        boolean b1 = clickButtonByImageFinalPixel(robot, "set_remark.png", 3);
        if(b1){
            //正常设置
        }else{
            System.out.println("未找到备注位置");
            return;
        }

        //全部删除
        clearAll(robot);

        setAndctrlVClipboardData2(beizhu);

        //发送请求
        clickButtonByImage(robot, "send_button.png", 1);

        //回到主页
        clickButtonByImage(robot,"return.png",3);

    }

    private static void clearAll(Robot robot){

        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);
        robot.keyPress(KeyEvent.VK_DELETE);
        robot.keyRelease(KeyEvent.VK_DELETE);


        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);

    }

    public static void pressNum(Robot robot,String num,int delay){

        ArrayList<Integer> list = new ArrayList<Integer>();

        if(num != null && !"".equals(num)){
            String[] nums = num.split("");

            if(nums.length > 0){
                for(String number : nums){
                    if("0".equals(number)){
                        list.add(KeyEvent.VK_0);
                    }else if("1".equals(number)){
                        list.add(KeyEvent.VK_1);
                    }if("2".equals(number)){
                        list.add(KeyEvent.VK_2);
                    }if("3".equals(number)){
                        list.add(KeyEvent.VK_3);
                    }if("4".equals(number)){
                        list.add(KeyEvent.VK_4);
                    }if("5".equals(number)){
                        list.add(KeyEvent.VK_5);
                    }if("6".equals(number)){
                        list.add(KeyEvent.VK_6);
                    }if("7".equals(number)){
                        list.add(KeyEvent.VK_7);
                    }if("8".equals(number)){
                        list.add(KeyEvent.VK_8);
                    }if("9".equals(number)){
                        list.add(KeyEvent.VK_9);
                    }
                }
            }

            robot.delay(500);
            pressKey(robot,list,500);
        }


    }

    public static void setAndctrlVClipboardData2(String string) throws AWTException {

        Robot robot = new Robot();

        //声明一个StingSelection 对象，并使用String的参数完成实例化；
        StringSelection stringSelection = new StringSelection(string);
        //使用Toolkit对象的setContents将字符串放到粘贴板中 ；
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

        //按下crtl shift v键 ；
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_V);
        //释放crtl shift v 键
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    public static void pressKey(Robot robot,ArrayList<Integer> keys,int delay){
        for(int i=0;i<keys.size();i++){
            robot.keyPress(keys.get(i));
            robot.keyRelease(keys.get(i));
            robot.delay(500);
        }
        //处理完需要延迟
        robot.delay(delay);
    }

    public static void clickMouse(Robot robot,int x,int y,int delay){
        robot.mouseMove(x, y);
        robot.delay(500);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(delay);
    }
}

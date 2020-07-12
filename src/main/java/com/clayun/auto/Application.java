package com.clayun.auto;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) throws AWTException {

        add("2-4","D:\\Documents\\Tencent Files\\1627072456\\FileRecv\\2-4.xlsx");

    }

    private static void add(String num,String path) throws AWTException {



        List<ExcelAdd> excelAdds = ExcelReader.readExcel(path);

        for(ExcelAdd excelAdd : excelAdds){
            String mobile = excelAdd.getMobile()+"";
            String beizhu = excelAdd.getName()+"孩子家长"+num;

            System.out.println("开始添加："+mobile+"  "+beizhu);
            operate(mobile,beizhu);
        }



    }

    private static void operate(String mobile,String beizhu) throws AWTException {
        Robot robot = new Robot();

        //尝试回到首页
        clickMouse(robot, 1505, 99, 300);
        clickMouse(robot, 1505, 99, 300);
        clickMouse(robot, 1505, 99, 300);

        //点击加号
        clickMouse(robot, 1888, 96, 300);
        //添加好友
        clickMouse(robot, 1822, 221, 300);
        //打开输入框
        clickMouse(robot, 1719, 146, 350);

//        setAndctrlVClipboardData2(mobile);
        pressNum(robot,mobile,500);

        //搜索
        clickMouse(robot, 1704, 161, 300);

        //发起邀请
        clickMouse(robot, 1711, 360, 300);
        clickMouse(robot, 1691, 414, 300);
        clickMouse(robot, 1712, 474, 300);
        clickMouse(robot, 1712, 536, 300);

        //点击设置备注
        clickMouse(robot, 1685, 454, 500);
        clickMouse(robot, 1685, 454, 500);

        //全部删除
        clearAll(robot);

        setAndctrlVClipboardData2(beizhu);

        clickMouse(robot, 1866, 98, 300);

        //回到主页
        clickMouse(robot, 1505, 99, 300);
        clickMouse(robot, 1505, 99, 300);
        clickMouse(robot, 1505, 99, 300);
        clickMouse(robot, 1505, 99, 300);
        clickMouse(robot, 1505, 99, 300);

    }

    private static void clearAll(Robot robot){
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

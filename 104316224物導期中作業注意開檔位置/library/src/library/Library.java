package library;

import java.io.*;
import java.lang.*;
import java.util.Scanner;

public class Library {

    static String[] k;
    static int mc;
    static int bc;
    static int cc;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        member[] m = new member[100];
        book[] b = new book[100];
        cd[] c = new cd[100];
        int yn = 0;
        /////////讀檔
        ReadFile(m, b, c);
        prin(m, b, c);
        ///////選項
        yn = cho(m, b, c);
        if (yn != 1) {
            WriteFile(m, b, c);//存檔
        }
    }

    public static int cho(member[] m, book[] b, cd[] c) {
        Scanner sc = new Scanner(System.in);
        int cho = 0;
        int yn = 0;
        int w1 = 0, w2 = 0;//搜尋判斷
        while (cho != -1) {

            System.out.println("1)新增會員圖書CD資料  2)刪除會員圖書CD資料  3)借閱還書(還款)催繳  4)修改會員資料  5)搜尋會員書籍CD  6)印出資料  -1)結束資料處理：");
            cho = sc.nextInt();
            if (cho == 1) {//新增
                newone(m, b, c);
            } else if (cho == 2) {//刪除
                del(m, b, c);
            } else if (cho == 3) {//借書還書催款
                bbb(m, b, c);
            } else if (cho == 4) {//修改會員資料
                chang(m, b, c);
            } else if (cho == 5) {//搜尋
                seach(m, b, c);
            } else if (cho == 6) {//印出
                prin(m, b, c);
            } else if (cho == -1) {//跳出
                System.out.println("是否存檔  1)否  其他選項)存檔：");
                yn = sc.nextInt();
                if (yn != 1) {
                    return yn;
                }//存檔
            } else {//重新輸入選項
                System.out.println("輸入錯誤");
            }
        }
        return yn;
    }

    public static void ReadFile(member[] m, book[] b, cd[] c) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("C:\\Users\\zi881\\Desktop\\大二上課程\\物導\\物導期中作業\\library\\角色資料.txt");
        BufferedReader br = new BufferedReader(fr);
        String s = new String();
        int i = 0;
        s = br.readLine();
        // System.out.println("s= "+s);
        while ((s = br.readLine()) != null) {
            k = s.split("\t");
            if (k[0].equalsIgnoreCase("M")) {
                m[mc] = new member("M", k[1], k[2], k[3], k[4], k[5]);
                mc++;
            } else if (k[0].equalsIgnoreCase("B")) {
                b[bc] = new book("B", k[1], k[2], k[3], k[4], k[5]);
                bc++;
            } else if (k[0].equalsIgnoreCase("C")) {
                c[cc] = new cd("C", k[1], k[2], k[3], k[4], k[5]);
                cc++;
            }
        }
        fr.close();
    }

    public static void newone(member[] m, book[] b, cd[] c) {
        Scanner sc = new Scanner(System.in);
        String[] s = new String[100];
        int can = 0;
        System.out.println("輸入身分別(會員編號M/書籍編號B/光碟編號C)：");
        s[0] = sc.next();
        if (s[0].equalsIgnoreCase("M")) {
            s[0] = "M";
            System.out.println("編號：");
            s[1] = sc.next();
            for (int i = 0; i < mc; i++) {
                if (m[i].No.equalsIgnoreCase(s[1])) {
                    can++;
                    System.out.println("有重複編號");
                }
            }
            if (can == 0) {
                System.out.println("姓名：");
                s[2] = sc.next();
                System.out.println("進入年分：");
                s[3] = sc.next();
                s[4] = "1";
                s[5] = "可借身分";
                m[mc] = new member(s[0], s[1], s[2], s[3], s[4], s[5]);
                mc++;
            }
        } else if (s[0].equalsIgnoreCase("B")) {
            s[0] = "B";
            System.out.println("編號：");
            s[1] = sc.next();
            for (int i = 0; i < bc; i++) {
                if (b[i].No.equalsIgnoreCase(s[1])) {
                    can++;
                    System.out.println("有重複編號");
                }
            }
            if (can == 0) {
                System.out.println("書本名稱：");
                s[2] = sc.next();
                System.out.println("進入年分：");
                s[3] = sc.next();
                System.out.println("注意選項(1可藉  (5珍藏：");
                s[4] = sc.next();
                while (s[4].equals("1") == false && s[4].equals("5") == false) {
                    System.out.println("輸入錯誤");
                    System.out.println("注意選項(1可藉  (5珍藏：");
                    s[4] = sc.next();
                }
                if (s[4].equalsIgnoreCase("1")) {
                    s[5] = "可借閱";
                }
                if (s[4].equalsIgnoreCase("5")) {
                    s[5] = "珍藏無法借出";
                }

                b[bc] = new book(s[0], s[1], s[2], s[3], s[4], s[5]);
                bc++;
            }
        } else if (s[0].equalsIgnoreCase("C")) {
            s[0] = "C";
            System.out.println("編號：");
            s[1] = sc.next();
            for (int i = 0; i < cc; i++) {
                if (c[i].No.equalsIgnoreCase(s[1])) {
                    can++;
                    System.out.println("有重複編號");
                }
            }
            if (can == 0) {
                System.out.println("CD名稱：");
                s[2] = sc.next();
                System.out.println("進入年分：");
                s[3] = sc.next();
                System.out.println("注意選項(1可藉  (5珍藏：");
                s[4] = sc.next();
                while (s[4].equals("1") == false && s[4].equals("5") == false) {
                    System.out.println("輸入錯誤");
                    System.out.println("注意選項(1可藉  (5珍藏：");
                    s[4] = sc.next();
                }
                if (s[4].equalsIgnoreCase("1")) {
                    s[5] = "可借閱";
                }
                if (s[4].equalsIgnoreCase("5")) {
                    s[5] = "珍藏無法借出";
                }

                c[cc] = new cd(s[0], s[1], s[2], s[3], s[4], s[5]);
                cc++;
            } else {
                System.out.println("無此身份別");
            }

        }
    }

    public static void prin(member[] m, book[] b, cd[] c) {
        System.out.println("身分別\t編號\t名稱\t進入年份\t角色注意選項\t注意資料");
        System.out.println("會員有：" + mc + "位");
        for (int i = 0; i < mc; i++) {
            System.out.println(m[i].IN + "\t" + m[i].No + "\t" + m[i].name + "\t" + m[i].year + "\t" + m[i].cho + "\t" + m[i].thing);
        }
        System.out.println("書有：" + bc + "本");
        for (int i = 0; i < bc; i++) {
            System.out.println(b[i].IN + "\t" + b[i].No + "\t" + b[i].name + "\t" + b[i].year + "\t" + b[i].cho + "\t" + b[i].thing);
        }
        System.out.println("CD有：" + cc + "片");
        for (int i = 0; i < cc; i++) {
            System.out.println(c[i].IN + "\t" + c[i].No + "\t" + c[i].name + "\t" + c[i].year + "\t" + c[i].cho + "\t" + c[i].thing);
        }
    }

    public static void WriteFile(member[] m, book[] b, cd[] c) throws FileNotFoundException, IOException {

        FileWriter fw = new FileWriter("C:\\Users\\zi881\\Desktop\\大二上課程\\物導\\library\\角色資料.txt");

        fw.write("身分(會員編號M/書籍編號B/光碟編號C) 編號 名稱 進入年份 角色注意選項(會員<1無預借無未歸還2未歸還3有預借4需催繳/書籍光碟<1可藉2已借出3已預借4需催繳5珍藏) 注意資料");
        fw.write('\r');
        fw.write('\n');
        for (int i = 0; i < mc; i++) {
            fw.write(m[i].IN + "\t" + m[i].No + "\t" + m[i].name + "\t" + m[i].year + "\t" + m[i].cho + "\t" + m[i].thing);
            fw.write('\r');
            fw.write('\n');
        }
        for (int i = 0; i < bc; i++) {
            fw.write(b[i].IN + "\t" + b[i].No + "\t" + b[i].name + "\t" + b[i].year + "\t" + b[i].cho + "\t" + b[i].thing);
            fw.write('\r');
            fw.write('\n');
        }
        for (int i = 0; i < cc; i++) {
            fw.write(c[i].IN + "\t" + c[i].No + "\t" + c[i].name + "\t" + c[i].year + "\t" + c[i].cho + "\t" + c[i].thing);
            fw.write('\r');
            fw.write('\n');
        }
        fw.close();
    }

    public static int seach(member[] m, book[] b, cd[] c) {
        int f = -1;
        int w1 = 0, w2 = 0;
        String no;
        Scanner sc = new Scanner(System.in);

        System.out.println("身分別  1)會員  2)書本  其他)CD：");
        w1 = sc.nextInt();

        System.out.println("1)編號  其他)名稱：");
        w2 = sc.nextInt();
        if (w1 == 1)//會員
        {
            if (w2 == 1) {
                System.out.println("編號：");
                no = sc.next();
                for (int i = 0; i < mc; i++) {
                    if (m[i].No.equalsIgnoreCase(no)) {
                        f = i + 10000;
                        System.out.println(m[i].IN + "\t" + m[i].No + "\t" + m[i].name + "\t" + m[i].year + "\t" + m[i].cho + "\t" + m[i].thing);
                    }
                }
            } else {
                System.out.println("姓名：");
                no = sc.next();
                for (int i = 0; i < mc; i++) {
                    if (m[i].name.equalsIgnoreCase(no)) {
                        f = i + 10000;
                        System.out.println(m[i].IN + "\t" + m[i].No + "\t" + m[i].name + "\t" + m[i].year + "\t" + m[i].cho + "\t" + m[i].thing);
                    }
                }
            }

        } else if (w1 == 2) {//書本
            if (w2 == 1) {
                System.out.println("編號：");
                no = sc.next();
                for (int i = 0; i < bc; i++) {
                    if (b[i].No.equalsIgnoreCase(no)) {
                        f = i + 20000;
                        System.out.println(b[i].IN + "\t" + b[i].No + "\t" + b[i].name + "\t" + b[i].year + "\t" + b[i].cho + "\t" + b[i].thing);
                    }
                }
            } else {
                System.out.println("名稱：");
                no = sc.next();
                for (int i = 0; i < bc; i++) {
                    if (b[i].name.equalsIgnoreCase(no)) {
                        f = i + 20000;
                        System.out.println(b[i].IN + "\t" + b[i].No + "\t" + b[i].name + "\t" + b[i].year + "\t" + b[i].cho + "\t" + b[i].thing);
                    }
                }
            }
        } else//CD
         if (w2 == 1) {
                System.out.println("編號：");
                no = sc.next();
                for (int i = 0; i < cc; i++) {
                    if (c[i].No.equalsIgnoreCase(no)) {
                        f = i + 30000;
                        System.out.println(c[i].IN + "\t" + c[i].No + "\t" + c[i].name + "\t" + c[i].year + "\t" + c[i].cho + "\t" + c[i].thing);
                    }
                }
            } else {
                System.out.println("名稱：");
                no = sc.next();
                for (int i = 0; i < cc; i++) {
                    if (c[i].name.equalsIgnoreCase(no)) {
                        f = i + 30000;
                        System.out.println(c[i].IN + "\t" + c[i].No + "\t" + c[i].name + "\t" + c[i].year + "\t" + c[i].cho + "\t" + c[i].thing);
                    }
                }
            }
        if (f == -1) {
            System.out.println("找無此資料\n");
        }
        return f;
    }

    public static void del(member[] m, book[] b, cd[] c) {
        int f = 0;
        int w1 = 0, w2 = 0;
        Scanner sc = new Scanner(System.in);
        int yn = 0;
        f = seach(m, b, c);
        w1 = f / 10000;
        w2 = f - 10000 * w1;
        if (f != -1) {
            System.out.println(w1 + "   " + w2 + "  " + "是否刪除  1)是  其他選項)否：");
            yn = sc.nextInt();
            if (yn == 1) {
                if (w1 == 1)//會員
                {
                    for (int i = w2; i < mc - w2; i++) {
                        m[i] = m[i + 1];
                    }
                    m[--mc] = null;
                } else if (w1 == 2) {//書本

                    for (int i = w2; i < bc - w2; i++) {
                        b[i] = b[i + 1];
                    }
                    b[--bc] = null;

                } else//CD
                {
                    for (int i = w2; i < cc - w2; i++) {
                        c[i] = c[i + 1];
                    }
                    c[--cc] = null;
                }
            } else {
                System.out.println("不刪除");
            }
        }
    }

    public static void bbb(member[] m, book[] b, cd[] c) {
        int cho = 0, f = 0, f2 = 0;
        String s;

        char[] ary2 = {'\0', '\0', '\0', '\0', '\0', '\0', '\0', '\0', '\0'};
int day=0;//還錢天數
        Scanner sc = new Scanner(System.in);
        int w1 = 0, w2 = 0, w11 = 0, w22 = 0;
        System.out.println("功能  1)借書  2)還書   3)預借書  4)借CD  5)還CD   6)預借CD  7)催繳書   其他)催繳CD：");
        cho = sc.nextInt();
        System.out.println("人：");
        f = seach(m, b, c);
        w1 = f / 10000;
        f = f - 10000 * w1;
        System.out.println("物：");
        f2 = seach(m, b, c);
        w11 = f2 / 10000;
        f2 = f2 - 10000 * w11;

        if (f != -1 && f2 != -1 && w1 != w11) {
            if (cho == 1) {//借書
                if (m[f].cho.equalsIgnoreCase("1") && b[f2].cho.equalsIgnoreCase("1")) {
                    m[f].cho = "2";
                    m[f].thing = "未歸還";
                    m[f].thing += b[f2].IN;
                    m[f].thing += b[f2].No;
                    b[f2].cho = "2";
                    b[f2].thing = "已借給";
                    b[f2].thing += m[f].IN;
                    b[f2].thing += m[f].No;
                } else {
                    System.out.println("不能借");
                }
            } else if (cho == 2) {//還書
                if (m[f].cho.equalsIgnoreCase("2") && b[f2].cho.equalsIgnoreCase("2")) {
                    char[] ary1 = m[f].thing.toCharArray();//人要還書的編碼
                    System.arraycopy(ary1, 4, ary2, 0, 9);
                    s = new String(ary2);
                    System.out.println(s);
                    if (b[f2].No.equalsIgnoreCase(s)) {
                        m[f].cho = "1";
                        m[f].thing = "可借身分";
                        b[f2].cho = "1";
                        b[f2].thing = "可借閱";
                        System.out.println("已歸還");
                    } else {
                        System.out.println("資料錯誤不能還書i i ");
                    }
                } else {
                    System.out.println("資料錯誤不能還書");
                }
            } else if (cho == 3) {//預借書
                if (m[f].cho.equalsIgnoreCase("1") && b[f2].cho.equalsIgnoreCase("1")) {
                    m[f].cho = "3";
                    m[f].thing = "有預借";
                    m[f].thing += b[f2].IN;
                    m[f].thing += b[f2].No;
                    b[f2].cho = "3";
                    b[f2].thing = "已預借給";
                    b[f2].thing += m[f].IN;
                    b[f2].thing += m[f].No;
                    System.out.println("預借完成");
                } else {
                    System.out.println("不能借");
                }
            } else if (cho == 4) {//借CD
                if (m[f].cho.equalsIgnoreCase("1") && c[f2].cho.equalsIgnoreCase("1")) {
                    m[f].cho = "2";
                    m[f].thing = "未歸還";
                    m[f].thing += c[f2].IN;
                    m[f].thing += c[f2].No;
                    c[f2].cho = "2";
                    c[f2].thing = "已借給";
                    c[f2].thing += m[f].IN;
                    c[f2].thing += m[f].No;
                } else {
                    System.out.println("不能借");
                }
            } else if (cho == 5) {//還CD
                if (m[f].cho.equalsIgnoreCase("2") && c[f2].cho.equalsIgnoreCase("2")) {
                    char[] ary1 = m[f].thing.toCharArray();//人要還書的編碼
                    System.arraycopy(ary1, 4, ary2, 0, 9);
                    s = new String(ary2);
                    //System.out.println(s);
                    if (c[f2].No.equalsIgnoreCase(s)) {
                        m[f].cho = "1";
                        m[f].thing = "可借身分";
                        c[f2].cho = "1";
                        c[f2].thing = "可借閱";
                        System.out.println("已歸還");
                    } else {
                        System.out.println("資料錯誤不能還書i i ");
                    }
                } else {
                    System.out.println("資料錯誤不能還書");
                }
            } else if (cho == 6) {//預借CD
                if (m[f].cho.equalsIgnoreCase("1") && c[f2].cho.equalsIgnoreCase("1")) {
                    m[f].cho = "3";
                    m[f].thing = "有預借";
                    m[f].thing += c[f2].IN;
                    m[f].thing += c[f2].No;
                    c[f2].cho = "3";
                    c[f2].thing = "已預借給";
                    c[f2].thing += m[f].IN;
                    c[f2].thing += m[f].No;
                    System.out.println("預借完成");
                } else {
                    System.out.println("不能借");
                }

            } else if (cho == 7) {//催繳書
                if (m[f].cho.equalsIgnoreCase("4") && b[f2].cho.equalsIgnoreCase("4")) {
                    char[] ary1 = m[f].thing.toCharArray();//人要催書的編碼
                    System.arraycopy(ary1, 4, ary2, 0, 9);
                    s = new String(ary2);
                   // System.out.println(s);
                    if (b[f2].No.equalsIgnoreCase(s)) {
                        System.out.println("已寄送催書單至" + m[f].IN + m[f].No + "信箱\n");
                    } else {
                        System.out.println("資料錯誤不需寄送催書單 ");
                    }
                } else {
                    System.out.println("資料錯誤不需寄送催書單");
                }
            } else//催繳CD
            {
                if (m[f].cho.equalsIgnoreCase("4") && c[f2].cho.equalsIgnoreCase("4")) {
                    char[] ary1 = m[f].thing.toCharArray();//人要催書的編碼
                    System.arraycopy(ary1, 4, ary2, 0, 9);
                    s = new String(ary2);
                    //System.out.println(s);
                   // System.out.println(c[f2].No);
                    if (c[f2].No.equalsIgnoreCase(s)) {
                           System.out.println("幾天未還：");
                         day = sc.nextInt();
                        System.out.println("已寄送催書單至" + m[f].IN + m[f].No + "信箱，需還款"+day*2+"元\n");
                    } else {
                        System.out.println("資料錯誤不需寄送催書單 ");
                    }
                } else {
                    System.out.println("資料錯誤不需寄送催書單??");
                }
            }
        } else {
            System.out.println("資料錯誤!!!");
        }
    }

    public static void chang(member[] m, book[] b, cd[] c) {
        int f = 0;
        int w1 = 0, w2 = 0;
        Scanner sc = new Scanner(System.in);
        int yn = 0;
        String s1;
        String s2;
        f = seach(m, b, c);
        w1 = f / 10000;
        w2 = f - 10000 * w1;
        if (f != -1) {
            System.out.println("修改名稱：");
            s1 = sc.next();
            System.out.println("修改進入年分：");
            s2 = sc.next();

            if (w1 == 1)//會員
            {
                m[w2].name = s1;
                m[w2].year = s2;
            } else {//書本CD
                System.out.println("只能修改會員");
            }
        }

    }
}

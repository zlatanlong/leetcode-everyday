package JavaDirTree.src;

import java.io.File;
import java.util.Scanner;

public class DirTree {
    public int levelCount = 1;

    /**
     * print this line's information, use | as file level
     * @param str file name
     */
    public void printLine(String str) {
        StringBuffer thisLine = new StringBuffer();
        thisLine.append("|");
        for (int i = 1; i < levelCount - 1; i++) {
            thisLine.append(" |");
        }
        thisLine.append("--").append(str);
        System.out.println(thisLine);
    }

    /**
     * the recursive function
     * @param fPath a absolutely file path
     */
    public void getDir(String fPath) {
        File currentFile = new File(fPath);
        if (currentFile.isDirectory()) {
            String[] childrenFileNameLists = currentFile.list();
            assert childrenFileNameLists != null;
            if (childrenFileNameLists.length > 0) {
                levelCount++;
                for (String childrenFileName : childrenFileNameLists) {
                    File childrenFile = new File(fPath + "/" + childrenFileName);
                    printLine(childrenFileName);
                    if (childrenFile.isDirectory()) {
                        getDir(fPath + "/" + childrenFileName);
                    }
                }
                levelCount--;
            }
        } else {
            System.out.println("不是目录");
        }
    }

    public static void main(String[] args) {
        DirTree dirTree = new DirTree();
        System.out.println("请输入想打印的文件目录");
        Scanner sc = new Scanner(System.in);
        String filePath = sc.nextLine();

        System.out.println(filePath);
        System.out.println(".");
        dirTree.getDir(filePath);
    }
}

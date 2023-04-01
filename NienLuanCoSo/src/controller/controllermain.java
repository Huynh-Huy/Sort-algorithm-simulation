/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.oSo;
import model.listSort;
import nienluancoso.hoanThanhJDialog;
import nienluancoso.viewWithoutCompareJPanel;

/**
 *
 * @author Tan Huy
 */
public class controllermain {

    private int luongThread = -1;
    private final Thread[] threads = new Thread[1000000];
    private final int waitingTime = 400;
    private int[] originPos_1;
    private int demSwap1 = 0;
    private final listSort listSortController = new listSort();

    public void finishAll() {
        for (int i = 0; i <= luongThread; i++) {
            try {
                threads[i].interrupt();
            } catch (Exception e) {
            }
        }
        luongThread = -1;
    }

    public boolean isFinished() {
        for (int i = 1; i <= luongThread; i++) {
            if (threads[i].isAlive()) {
                return false;
            }
        }
        return true;
    }

    public void Swap(LinkedList<oSo> arrayListOSo, int x, int y) {
        luongThread++;
        System.out.println(luongThread);
        int cur = luongThread;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        threads[cur - 1].join();
                    }
                    arrayListOSo.get(x).highlight();
                    arrayListOSo.get(y).highlight();
                    int x1 = arrayListOSo.get(x).getX();
                    int y1 = arrayListOSo.get(x).getY();
                    int x2 = arrayListOSo.get(y).getX();
                    int y2 = arrayListOSo.get(y).getY();
                    arrayListOSo.get(x).setLocation(x1, y1 + 50);
                    arrayListOSo.get(y).setLocation(x2, y2 - 50);
                    Thread.sleep(waitingTime);
                    arrayListOSo.get(x).setLocation(x2, y1 + 50);
                    arrayListOSo.get(y).setLocation(x1, y2 - 50);
                    Thread.sleep(waitingTime);
                    arrayListOSo.get(x).setLocation(x2, y1);
                    arrayListOSo.get(y).setLocation(x1, y2);
                    Thread.sleep(waitingTime);
                    oSo temp_OSo = arrayListOSo.get(x);
                    arrayListOSo.set(x, arrayListOSo.get(y));
                    arrayListOSo.set(y, temp_OSo);
                    arrayListOSo.get(x).unHighlight();
                    arrayListOSo.get(y).unHighlight();
                } catch (Exception e) {

                }

            }
        });
        threads[cur].start();
    }
    public void readFile(JPanel ViewRootPanel, LinkedList<Integer> arrayList, LinkedList<oSo> arrayListOSo, int soLuongGiaiThuat, int firstAlgorithmSelected, int chieuSapXep) throws FileNotFoundException, IOException {
        JFrame parentFrame = new JFrame();
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        fileChooser.setFileFilter(filter);
        fileChooser.setDialogTitle("Chọn file cần mở");
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(parentFrame);
        if (result == JFileChooser.APPROVE_OPTION) {
            try ( Scanner scanner = new Scanner(new File(fileChooser.getSelectedFile().getAbsolutePath()));) {
                arrayList.clear();
                int soLuong;
                soLuong = scanner.nextInt();
                for (int i = 0; i < soLuong; i++) {
                    arrayList.add(scanner.nextInt());
                    //arrayList_2.add(arrayList_1.get(i));
                }

            } catch (IOException e) {
                //return -1;
            }
        }
    }
    
    public void startBubbleSort(LinkedList<Integer> arrayList, LinkedList<oSo> arrayListOSo, int chieuSapXep, JPanel ViewRootPanel) throws InterruptedException {
        
        luongThread++;
        int cur = luongThread;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (chieuSapXep != 0) {
                        //System.out.print(arrayList + "\n");
                        for (int i = 0; i <= arrayList.size() - 2; i++) {                         
                            for (int j = arrayList.size() - 1; j >= i + 1; j--) {
                                arrayListOSo.get(j).highlight();                               
                                if (arrayList.get(j) < arrayList.get(j - 1)) {
                                    int x = j;
                                    int y = j - 1;
                                    //arrayListOSo.get(j - 1).highlight();
                                    int temp = arrayList.get(x);//swap con so
                                    arrayList.set(x, arrayList.get(y));//chay bang tt
                                    arrayList.set(y, temp);//list chay trong may
                                    demSwap1++;
                                    int x1 = arrayListOSo.get(x).getX();
                                    int y1 = arrayListOSo.get(x).getY();
                                    int x2 = arrayListOSo.get(y).getX();
                                    int y2 = arrayListOSo.get(y).getY();
                                    arrayListOSo.get(x).setLocation(x1, y1 + 50);
                                    arrayListOSo.get(y).setLocation(x2, y2 - 50);
                                    Thread.sleep(waitingTime);//dung lai khoang tg
                                    arrayListOSo.get(x).setLocation(x2, y1 + 50);
                                    arrayListOSo.get(y).setLocation(x1, y2 - 50);
                                    Thread.sleep(waitingTime);
                                    arrayListOSo.get(x).setLocation(x2, y1);
                                    arrayListOSo.get(y).setLocation(x1, y2);
                                    Thread.sleep(waitingTime);
                                    oSo temp_OSo = arrayListOSo.get(x);
                                    arrayListOSo.set(x, arrayListOSo.get(y));
                                    arrayListOSo.set(y, temp_OSo);
                                }
                                arrayListOSo.get(j).unHighlight();
                                arrayListOSo.get(j - 1).unHighlight();
                            }
                        }
                        System.out.print(arrayList);
                    } else {
                        System.out.print(arrayList + "\n");
                        for (int i = 0; i <= arrayList.size() - 2; i++) {
                            //Thread.sleep(waitingTime);
                            for (int j = arrayList.size() - 1; j >= i + 1; j--) {
                                arrayListOSo.get(j).highlight();
                                //Thread.sleep(waitingTime);
                                if (arrayList.get(j) >= arrayList.get(j - 1)) {
                                    int x = j;
                                    int y = j - 1;
                                    arrayListOSo.get(j - 1).highlight();
                                    int temp = arrayList.get(x);
                                    arrayList.set(x, arrayList.get(y));
                                    arrayList.set(y, temp);
                                    demSwap1++;
                                    int x1 = arrayListOSo.get(x).getX();//doi bị tri cua 2 con so
                                    int y1 = arrayListOSo.get(x).getY();
                                    int x2 = arrayListOSo.get(y).getX();
                                    int y2 = arrayListOSo.get(y).getY();
                                    arrayListOSo.get(x).setLocation(x1, y1 + 50);
                                    arrayListOSo.get(y).setLocation(x2, y2 - 50);
                                    Thread.sleep(waitingTime);
                                    arrayListOSo.get(x).setLocation(x2, y1 + 50);
                                    arrayListOSo.get(y).setLocation(x1, y2 - 50);
                                    Thread.sleep(waitingTime);
                                    arrayListOSo.get(x).setLocation(x2, y1);
                                    arrayListOSo.get(y).setLocation(x1, y2);
                                    Thread.sleep(waitingTime);
                                    oSo temp_OSo = arrayListOSo.get(x);
                                    arrayListOSo.set(x, arrayListOSo.get(y));
                                    arrayListOSo.set(y, temp_OSo);
                                }
                                arrayListOSo.get(j).unHighlight();
                                arrayListOSo.get(j - 1).unHighlight();
                            }
                        }
                        System.out.print(arrayList);
                    }
                } catch (InterruptedException e) {
                }
            }
        });
        threads[cur].start();
    }

    public void startInsertionSort(LinkedList<Integer> arrayList, LinkedList<oSo> arrayListOSo, int chieuSapXep, JPanel ViewRootPanel) throws InterruptedException {
        luongThread++;
        System.out.println(luongThread);
        int cur = luongThread;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (chieuSapXep != 0) {
                        System.out.print(arrayList + "\n");
                        for (int i = 1; i <= arrayList.size() - 1; i++) {
                            int j = i;
                            while ((j > 0) && arrayList.get(j) < arrayList.get(j - 1)) {
                                arrayListOSo.get(j).highlight();
                                int x = j;
                                int y = j - 1;
                                arrayListOSo.get(j - 1).highlight();
                                int temp = arrayList.get(x);
                                arrayList.set(x, arrayList.get(y));
                                arrayList.set(y, temp);
                                demSwap1++;
                                int x1 = arrayListOSo.get(x).getX();
                                int y1 = arrayListOSo.get(x).getY();
                                int x2 = arrayListOSo.get(y).getX();
                                int y2 = arrayListOSo.get(y).getY();
                                arrayListOSo.get(x).setLocation(x1, y1 + 50);
                                arrayListOSo.get(y).setLocation(x2, y2 - 50);
                                Thread.sleep(waitingTime);
                                arrayListOSo.get(x).setLocation(x2, y1 + 50);
                                arrayListOSo.get(y).setLocation(x1, y2 - 50);
                                Thread.sleep(waitingTime);
                                arrayListOSo.get(x).setLocation(x2, y1);
                                arrayListOSo.get(y).setLocation(x1, y2);
                                Thread.sleep(waitingTime);
                                oSo temp_OSo = arrayListOSo.get(x);
                                arrayListOSo.set(x, arrayListOSo.get(y));
                                arrayListOSo.set(y, temp_OSo);
                                arrayListOSo.get(j).unHighlight();
                                arrayListOSo.get(j - 1).unHighlight();
                                j--;
                            }
                        }
                        System.out.print(arrayList);
                    } else {
                        System.out.print(arrayList + "\n");
                        for (int i = 1; i <= arrayList.size() - 1; i++) {
                            //Thread.sleep(waitingTime);
                            int j = i;
                            while ((j > 0) && arrayList.get(j) >= arrayList.get(j - 1)) {
                                arrayListOSo.get(j).highlight();
                                //Thread.sleep(waitingTime);
                                int x = j;
                                int y = j - 1;
                                arrayListOSo.get(j - 1).highlight();
                                int temp = arrayList.get(x);
                                arrayList.set(x, arrayList.get(y));
                                arrayList.set(y, temp);
                                demSwap1++;
                                int x1 = arrayListOSo.get(x).getX();
                                int y1 = arrayListOSo.get(x).getY();
                                int x2 = arrayListOSo.get(y).getX();
                                int y2 = arrayListOSo.get(y).getY();
                                arrayListOSo.get(x).setLocation(x1, y1 + 50);
                                arrayListOSo.get(y).setLocation(x2, y2 - 50);
                                Thread.sleep(waitingTime);
                                arrayListOSo.get(x).setLocation(x2, y1 + 50);
                                arrayListOSo.get(y).setLocation(x1, y2 - 50);
                                Thread.sleep(waitingTime);
                                arrayListOSo.get(x).setLocation(x2, y1);
                                arrayListOSo.get(y).setLocation(x1, y2);
                                Thread.sleep(waitingTime);
                                oSo temp_OSo = arrayListOSo.get(x);
                                arrayListOSo.set(x, arrayListOSo.get(y));
                                arrayListOSo.set(y, temp_OSo);
                                arrayListOSo.get(j).unHighlight();
                                arrayListOSo.get(j - 1).unHighlight();
                                j--;
                            }
                        }
                        System.out.print(arrayList);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        threads[cur].start();
    }

    public void startSelectionSort(LinkedList<Integer> arrayList, LinkedList<oSo> arrayListOSo, int chieuSapXep, JPanel ViewRootPanel) throws InterruptedException {
        luongThread++;
        System.out.println(luongThread);
        int cur = luongThread;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (chieuSapXep != 0) {
                        System.out.print(arrayList + "\n");
                        for (int i = 0; i <= arrayList.size() - 2; i++) {

                            arrayListOSo.get(i).highlight();
                            int lowIndex = i;
                            int lowKey = arrayList.get(i);
                            //Thread.sleep(waitingTime);
                            for (int j = i + 1; j < arrayList.size(); j++) {
                                if (arrayList.get(j) < lowKey) {
                                    lowIndex = j;
                                    lowKey = arrayList.get(j);
                                }
                            }
                            int x = lowIndex;
                            int y = i;
                            arrayListOSo.get(x).highlight();
                            if (x != y) {
                                int temp = arrayList.get(x);
                                arrayList.set(x, arrayList.get(y));
                                arrayList.set(y, temp);
                                demSwap1++;
                                System.out.print(x + " " + y + "\n");
                                int x1 = arrayListOSo.get(x).getX();
                                int y1 = arrayListOSo.get(x).getY();
                                int x2 = arrayListOSo.get(y).getX();
                                int y2 = arrayListOSo.get(y).getY();
                                arrayListOSo.get(x).setLocation(x1, y1 + 50);
                                arrayListOSo.get(y).setLocation(x2, y2 - 50);
                                Thread.sleep(waitingTime);
                                arrayListOSo.get(x).setLocation(x2, y1 + 50);
                                arrayListOSo.get(y).setLocation(x1, y2 - 50);
                                Thread.sleep(waitingTime);
                                arrayListOSo.get(x).setLocation(x2, y1);
                                arrayListOSo.get(y).setLocation(x1, y2);
                                Thread.sleep(waitingTime);
                                oSo temp_OSo = arrayListOSo.get(x);
                                arrayListOSo.set(x, arrayListOSo.get(y));
                                arrayListOSo.set(y, temp_OSo);
                            }
                            arrayListOSo.get(x).unHighlight();
                            arrayListOSo.get(y).unHighlight();

                        }
                        System.out.print(arrayList);
                    } else {
                        System.out.print(arrayList + "\n");
                        for (int i = 0; i <= arrayList.size() - 2; i++) {

                            arrayListOSo.get(i).highlight();
                            int lowIndex = i;
                            int lowKey = arrayList.get(i);
                            //Thread.sleep(waitingTime);
                            for (int j = i + 1; j < arrayList.size(); j++) {
                                if (arrayList.get(j) >= lowKey) {
                                    lowIndex = j;
                                    lowKey = arrayList.get(j);
                                }
                            }
                            int x = lowIndex;
                            int y = i;
                            arrayListOSo.get(x).highlight();
                            if (x != y) {
                                int temp = arrayList.get(x);
                                arrayList.set(x, arrayList.get(y));
                                arrayList.set(y, temp);
                                demSwap1++;
                                System.out.print(x + " " + y + "\n");
                                int x1 = arrayListOSo.get(x).getX();
                                int y1 = arrayListOSo.get(x).getY();
                                int x2 = arrayListOSo.get(y).getX();
                                int y2 = arrayListOSo.get(y).getY();
                                arrayListOSo.get(x).setLocation(x1, y1 + 50);
                                arrayListOSo.get(y).setLocation(x2, y2 - 50);
                                Thread.sleep(waitingTime);
                                arrayListOSo.get(x).setLocation(x2, y1 + 50);
                                arrayListOSo.get(y).setLocation(x1, y2 - 50);
                                Thread.sleep(waitingTime);
                                arrayListOSo.get(x).setLocation(x2, y1);
                                arrayListOSo.get(y).setLocation(x1, y2);
                                Thread.sleep(waitingTime);
                                oSo temp_OSo = arrayListOSo.get(x);
                                arrayListOSo.set(x, arrayListOSo.get(y));
                                arrayListOSo.set(y, temp_OSo);
                            }
                            arrayListOSo.get(x).unHighlight();
                            arrayListOSo.get(y).unHighlight();

                        }
                        System.out.print(arrayList);
                    }
                } catch (Exception e) {
                }
            }
        });
        threads[cur].start();
    }

    public void putDownMergeSort(LinkedList<oSo> arrayListOSo, int res, int X) {
        demSwap1++;
        luongThread++;
        System.out.println(luongThread + ": putDown");
        int cur = luongThread;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        threads[cur - 1].join();
                    }
                    int dem = 0;
                    while (dem < 5) {
                        arrayListOSo.get(res).setLocation(X, arrayListOSo.get(res).getY() + 10);
                        Thread.sleep(30);
                        dem++;
                    }

                } catch (Exception e) {
                }
            }
        });
        threads[cur].start();
    }

    public void putUpMergeSort(JPanel ViewRootPanel, LinkedList<oSo> arrayListOSo, int left, int right) {
        //demSwap1++;
        luongThread++;
        System.out.println(luongThread + ": putUp");
        int cur = luongThread;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        threads[cur - 1].join();
                    }
                    for (int i = left; i <= right; i++) {
                        int dem = 0;
                        while (dem < 5) {
                            arrayListOSo.get(i).setLocation(arrayListOSo.get(i).getX(), arrayListOSo.get(i).getY() - 10);
                            Thread.sleep(30);
                            dem++;
                        }
                    }
                    Thread.sleep(waitingTime);
                } catch (Exception e) {
                }
            }
        });
        threads[cur].start();
    }

    //Định vị lại các ô số sau khi sắp xếp (thay đổi giá trị hiển trị trên ô)
    public void reLocation(LinkedList<oSo> arrayListOSo, int[] T, int left, int right) {
        //demSwap1++;
        luongThread++;
        System.out.println(luongThread + ": reLocation");
        int cur = luongThread;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        threads[cur - 1].join();
                    }
                    for (int i = left; i <= right; i++) {
                        if (arrayListOSo.get(i).getX() != originPos_1[i]) {
                            arrayListOSo.get(i).setLocation(originPos_1[i], arrayListOSo.get(i).getY());
                            arrayListOSo.get(i).setOSO("" + T[i - left]);
                        }
                    }
                } catch (Exception e) {
                }
            }
        });
        threads[cur].start();
    }

    public void startMerge(LinkedList<Integer> arrayList, LinkedList<oSo> arrayListOSo, int chieuSapXep, JPanel ViewRootPanel, int left, int mid, int right) throws InterruptedException {
        if (chieuSapXep != 0) {
            int n1 = mid - left + 1;
            int n2 = right - mid;
            int[] T = new int[n1 + n2];
            int[] L = new int[n1];
            int[] R = new int[n2];
            int i, j, k;
            for (i = 0; i < n1; i++) {
                L[i] = arrayList.get(left + i);
            }
            for (j = 0; j < n2; j++) {
                R[j] = arrayList.get(mid + 1 + j);
            }
            i = 0;
            j = 0;
            k = left;
            while (i < n1 && j < n2) {
                if (L[i] <= R[j]) {
                    arrayList.set(k, L[i]);
                    putDownMergeSort(arrayListOSo, left + i, originPos_1[k]);
                    i++;
                } else {
                    arrayList.set(k, R[j]);
                    putDownMergeSort(arrayListOSo, mid + 1 + j, originPos_1[k]);
                    j++;
                }
                k++;
            }
            while (i < n1) {
                arrayList.set(k, L[i]);
                putDownMergeSort(arrayListOSo, left + i, originPos_1[k]);
                i++;
                k++;
            }
            while (j < n2) {
                arrayList.set(k, R[j]);
                putDownMergeSort(arrayListOSo, mid + 1 + j, originPos_1[k]);
                j++;
                k++;
            }
            putUpMergeSort(ViewRootPanel, arrayListOSo, left, right);
            for (i = 0; i < n1 + n2; i++) {
                T[i] = arrayList.get(left + i);
            }
            System.out.println(arrayList);
            reLocation(arrayListOSo, T, left, right);
        } else {
            int n1 = mid - left + 1;
            int n2 = right - mid;
            int[] T = new int[n1 + n2];
            int[] L = new int[n1];
            int[] R = new int[n2];
            int i, j, k;
            for (i = 0; i < n1; i++) {
                L[i] = arrayList.get(left + i);
            }
            for (j = 0; j < n2; j++) {
                R[j] = arrayList.get(mid + 1 + j);
            }
            i = 0;
            j = 0;
            k = left;
            while (i < n1 && j < n2) {
                if (L[i] > R[j]) {
                    arrayList.set(k, L[i]);
                    putDownMergeSort(arrayListOSo, left + i, originPos_1[k]);
                    i++;
                } else {
                    arrayList.set(k, R[j]);
                    putDownMergeSort(arrayListOSo, mid + 1 + j, originPos_1[k]);
                    j++;
                }
                k++;
            }
            while (i < n1) {
                arrayList.set(k, L[i]);
                putDownMergeSort(arrayListOSo, left + i, originPos_1[k]);
                i++;
                k++;
            }
            while (j < n2) {
                arrayList.set(k, R[j]);
                putDownMergeSort(arrayListOSo, mid + 1 + j, originPos_1[k]);
                j++;
                k++;
            }
            putUpMergeSort(ViewRootPanel, arrayListOSo, left, right);
            for (i = 0; i < n1 + n2; i++) {
                T[i] = arrayList.get(left + i);
            }
            System.out.println(arrayList);
            reLocation(arrayListOSo, T, left, right);
        }
    }

    public void startMergeSort(LinkedList<Integer> arrayList, LinkedList<oSo> arrayListOSo, int chieuSapXep, JPanel ViewRootPanel, int left, int right) throws InterruptedException {
        if (left < right) {
            int mid = (right + left) / 2;
            startMergeSort(arrayList, arrayListOSo, chieuSapXep, ViewRootPanel, left, mid);
            startMergeSort(arrayList, arrayListOSo, chieuSapXep, ViewRootPanel, mid + 1, right);
            startMerge(arrayList, arrayListOSo, chieuSapXep, ViewRootPanel, left, mid, right);
        }
    }

    public void QuickSort(LinkedList<Integer> arrayList, LinkedList<oSo> arrayListOSo, int chieuSapXep, JPanel ViewRootPanel, int left, int right) {
        luongThread++;
        System.out.println(luongThread);
        int cur = luongThread;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        threads[cur - 1].join();
                    }
                    if (chieuSapXep != 0) {
                        int l = left;
                        int r = right;
                        int medianPos = (left + right) / 2;
                        int median = arrayList.get(medianPos);
                        arrayListOSo.get(medianPos).highlight();
                        Thread.sleep(waitingTime);
                        while (l < r) {
                            while (arrayList.get(l) < median) {
                                l++;
                            }
                            while (arrayList.get(r) > median) {
                                r--;
                            }
                            if (l <= r) {
                                int temp = arrayList.get(l);
                                arrayList.set(l, arrayList.get(r));
                                arrayList.set(r, temp);
                                demSwap1++;
                                Swap(arrayListOSo, l, r);
                                l++;
                                r--;
                            }
                        }
                        arrayListOSo.get(medianPos).unHighlight();
                        if (left < r) {
                            QuickSort(arrayList, arrayListOSo, chieuSapXep, ViewRootPanel, left, r);
                        }
                        if (l < right) {
                            QuickSort(arrayList, arrayListOSo, chieuSapXep, ViewRootPanel, l, right);
                        }
                        System.out.println(arrayList);
                    } else {
                        int l = left;
                        int r = right;
                        int medianPos = (left + right) / 2;
                        int median = arrayList.get(medianPos);
                        arrayListOSo.get(medianPos).highlight();
                        Thread.sleep(waitingTime);
                        while (l < r) {
                            while (arrayList.get(l) > median) {
                                l++;
                            }
                            while (arrayList.get(r) < median) {
                                r--;
                            }
                            if (l <= r) {
                                int temp = arrayList.get(l);
                                arrayList.set(l, arrayList.get(r));
                                arrayList.set(r, temp);
                                demSwap1++;
                                Swap(arrayListOSo, l, r);
                                l++;
                                r--;
                            }
                        }
                        arrayListOSo.get(medianPos).unHighlight();
                        if (left < r) {
                            QuickSort(arrayList, arrayListOSo, chieuSapXep, ViewRootPanel, left, r);
                        }
                        if (l < right) {
                            QuickSort(arrayList, arrayListOSo, chieuSapXep, ViewRootPanel, l, right);
                        }
                        System.out.println(arrayList);
                    }
                } catch (Exception e) {
                }
            }
        });
        threads[cur].start();
    }

    public void startQuickSort(LinkedList<Integer> arrayList, LinkedList<oSo> arrayListOSo, int chieuSapXep, JPanel ViewRootPanel) {
        luongThread++;
        System.out.println(luongThread);
        int cur = luongThread;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    QuickSort(arrayList, arrayListOSo, chieuSapXep, ViewRootPanel, 0, arrayListOSo.size() - 1);
                } catch (Exception e) {

                }
            }
        });
        threads[cur].start();
    }

    public void QuickSortBienThe(LinkedList<Integer> arrayList, LinkedList<oSo> arrayListOSo, int chieuSapXep, JPanel ViewRootPanel, int left, int right) {
        luongThread++;
        System.out.println(luongThread);
        int cur = luongThread;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (cur != 0) {
                        threads[cur - 1].join();
                    }
                    if (chieuSapXep != 0) {
                        int l = left;
                        int r = right;
                        int medianPos = left;
                        int median = arrayList.get(medianPos);
                        arrayListOSo.get(medianPos).highlight();
                        Thread.sleep(waitingTime);
                        while (l < r) {
                            while (arrayList.get(l) < median) {
                                l++;
                            }
                            while (arrayList.get(r) > median) {
                                r--;
                            }
                            if (l <= r) {
                                int temp = arrayList.get(l);
                                arrayList.set(l, arrayList.get(r));
                                arrayList.set(r, temp);
                                demSwap1++;
                                Swap(arrayListOSo, l, r);
                                l++;
                                r--;
                            }
                        }
                        arrayListOSo.get(medianPos).unHighlight();
                        if (left < r) {
                            QuickSortBienThe(arrayList, arrayListOSo, chieuSapXep, ViewRootPanel, left, r);
                        }
                        if (l < right) {
                            QuickSortBienThe(arrayList, arrayListOSo, chieuSapXep, ViewRootPanel, l, right);
                        }
                        System.out.println(arrayList);
                    } else {
                        int l = left;
                        int r = right;
                        int medianPos = left;
                        int median = arrayList.get(medianPos);
                        arrayListOSo.get(medianPos).highlight();
                        Thread.sleep(waitingTime);
                        while (l < r) {
                            while (arrayList.get(l) > median) {
                                l++;
                            }
                            while (arrayList.get(r) < median) {
                                r--;
                            }
                            if (l <= r) {
                                int temp = arrayList.get(l);
                                arrayList.set(l, arrayList.get(r));
                                arrayList.set(r, temp);
                                demSwap1++;
                                Swap(arrayListOSo, l, r);
                                l++;
                                r--;
                            }
                        }
                        arrayListOSo.get(medianPos).unHighlight();
                        if (left < r) {
                            QuickSortBienThe(arrayList, arrayListOSo, chieuSapXep, ViewRootPanel, left, r);
                        }
                        if (l < right) {
                            QuickSortBienThe(arrayList, arrayListOSo, chieuSapXep, ViewRootPanel, l, right);
                        }
                        System.out.println(arrayList);
                    }
                } catch (Exception e) {

                }

            }
        });
        threads[cur].start();
    }

    public void startQuickSortBienThe(LinkedList<Integer> arrayList, LinkedList<oSo> arrayListOSo, int chieuSapXep, JPanel ViewRootPanel) {
        luongThread++;
        System.out.println(luongThread);
        int cur = luongThread;
        threads[cur] = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    QuickSortBienThe(arrayList, arrayListOSo, chieuSapXep, ViewRootPanel, 0, arrayListOSo.size() - 1);
                } catch (Exception e) {

                }

            }
        });
        threads[cur].start();
    }

    public void PushDown(LinkedList<Integer> arrayList, LinkedList<oSo> arrayListOSo, int chieuSapXep, int first, int last) {
        luongThread++;
        System.out.println(luongThread);
        int cur = luongThread;
        threads[cur] = new Thread(() -> {
            try {
                if (cur != 0) {
                    threads[cur - 1].join();
                }
                if (chieuSapXep == 0) {
                    int r = first;
                    while (r <= (last - 1) / 2) {
                        if (last == 2 * r + 1) {
                            if (arrayList.get(r) > arrayList.get(last)) {
                                int temp = arrayList.get(r);
                                arrayList.set(r, arrayList.get(last));
                                arrayList.set(last, temp);
                                demSwap1++;
                                Swap(arrayListOSo, r, last);
                            }
                            r = last;
                        } else if ((arrayList.get(r) > arrayList.get(2 * r + 1)) && (arrayList.get(2 * r + 1) <= arrayList.get(2 * r + 2))) {
                            int temp = arrayList.get(r);
                            arrayList.set(r, arrayList.get(2 * r + 1));
                            arrayList.set(2 * r + 1, temp);
                            demSwap1++;
                            Swap(arrayListOSo, r, 2 * r + 1);
                            r = 2 * r + 1;
                        } else if ((arrayList.get(r) > arrayList.get(2 * r + 2)) && (arrayList.get(2 * r + 2) < arrayList.get(2 * r + 1))) {
                            int temp = arrayList.get(r);
                            arrayList.set(r, arrayList.get(2 * r + 2));
                            arrayList.set(2 * r + 2, temp);
                            demSwap1++;
                            Swap(arrayListOSo, r, 2 * r + 2);
                            r = 2 * r + 2;
                        } else {
                            r = last;
                        }
                    }
                } else {
                    int r = first;
                    while (r <= (last - 1) / 2) {
                        if (last == 2 * r + 1) {
                            if (arrayList.get(r) < arrayList.get(last)) {
                                int temp = arrayList.get(r);
                                arrayList.set(r, arrayList.get(last));
                                arrayList.set(last, temp);
                                demSwap1++;
                                Swap(arrayListOSo, r, last);
                            }
                            r = last;
                        } else if ((arrayList.get(r) < arrayList.get(2 * r + 1)) && (arrayList.get(2 * r + 1) > arrayList.get(2 * r + 2))) {
                            int temp = arrayList.get(r);
                            arrayList.set(r, arrayList.get(2 * r + 1));
                            arrayList.set(2 * r + 1, temp);
                            demSwap1++;
                            Swap(arrayListOSo, r, 2 * r + 1);
                            r = 2 * r + 1;
                        } else if ((arrayList.get(r) < arrayList.get(2 * r + 2)) && (arrayList.get(2 * r + 2) > arrayList.get(2 * r + 1))) {
                            int temp = arrayList.get(r);
                            arrayList.set(r, arrayList.get(2 * r + 2));
                            arrayList.set(2 * r + 2, temp);
                            demSwap1++;
                            Swap(arrayListOSo, r, 2 * r + 2);
                            r = 2 * r + 2;
                        } else {
                            r = last;
                        }
                    }
                }
            } catch (InterruptedException e) {
            }
        });
        threads[cur].start();
    }

    public void startHeapSort(LinkedList<Integer> arrayList, LinkedList<oSo> arrayListOSo, int chieuSapXep, JPanel ViewRootPanel) {
        luongThread++;
        System.out.println(luongThread);
        int cur = luongThread;
        threads[cur] = new Thread(() -> {
            try {
                int i;
                for (i = ((arrayList.size() - 2) / 2); i >= 0; i--) {
                    PushDown(arrayList, arrayListOSo, chieuSapXep, i, arrayList.size() - 1);
                }
                for (i = arrayList.size() - 1; i >= 2; i--) {
                    int temp = arrayList.get(i);
                    arrayList.set(i, arrayList.get(0));
                    arrayList.set(0, temp);
                    Swap(arrayListOSo, 0, i);
                    demSwap1++;
                    PushDown(arrayList, arrayListOSo, chieuSapXep, 0, i - 1);
                }
                int temp = arrayList.get(1);
                arrayList.set(1, arrayList.get(0));
                arrayList.set(0, temp);
                demSwap1++;
                Swap(arrayListOSo, 0, 1);
            } catch (Exception e) {

            }
        });
        threads[cur].start();
    }

    public void startHeapSortNew(LinkedList<Integer> arrayList, LinkedList<oSo> arrayListOSo, int chieuSapXep, JPanel ViewRootPanel) {
        int n = arrayList.size();
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapifyHeapSortTest(arrayList, arrayListOSo, chieuSapXep, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = arrayList.get(0);
            arrayList.set(0, arrayList.get(i));
            arrayList.set(i, temp);
            demSwap1++;
            Swap(arrayListOSo, 0, i);
            System.out.println(arrayList);
            heapifyHeapSortTest(arrayList, arrayListOSo, chieuSapXep, i, 0);
        }
    }

    void heapifyHeapSortTest(LinkedList<Integer> arrayList, LinkedList<oSo> arrayListOSo, int chieuSapXep, int first, int last) {
        if (chieuSapXep == 1) {
            int largest = last;
            int l = 2 * last + 1;
            int r = 2 * last + 2;
            if (l < first && arrayList.get(l) > arrayList.get(largest)) {
                largest = l;
            }
            if (r < first && arrayList.get(r) > arrayList.get(largest)) {
                largest = r;
            }
            if (largest != last) {
                int temp = arrayList.get(last);
                arrayList.set(last, arrayList.get(largest));
                arrayList.set(largest, temp);
                demSwap1++;
                Swap(arrayListOSo, last, largest);
                System.out.println(arrayList);
                heapifyHeapSortTest(arrayList, arrayListOSo, chieuSapXep, first, largest);
            }
        } else {
            int largest = last;
            int l = 2 * last + 1;
            int r = 2 * last + 2;
            if (l < first && arrayList.get(l) < arrayList.get(largest)) {
                largest = l;
            }
            if (r < first && arrayList.get(r) < arrayList.get(largest)) {
                largest = r;
            }
            if (largest != last) {
                int temp = arrayList.get(last);
                arrayList.set(last, arrayList.get(largest));
                arrayList.set(largest, temp);
                demSwap1++;
                Swap(arrayListOSo, last, largest);
                System.out.println(arrayList);
                heapifyHeapSortTest(arrayList, arrayListOSo, chieuSapXep, first, largest);
            }
        }
    }

    private void callSortFunction_1(LinkedList<Integer> arrayList, LinkedList<oSo> arrayListOSo, int AlgorithmSelected, int chieuSapXep, JPanel ViewRootPanel) {
        if (AlgorithmSelected == 0) {
            luongThread++;
            System.out.println(luongThread);
            int cur = luongThread;
            threads[cur] = new Thread(() -> {
                try {
                    startBubbleSort(arrayList, arrayListOSo, chieuSapXep, ViewRootPanel);
                } catch (InterruptedException e) {
                }
            });
            threads[cur].start();
        }
        if (AlgorithmSelected == 1) {
            luongThread++;
            System.out.println(luongThread);
            int cur = luongThread;
            threads[cur] = new Thread(() -> {
                try {
                    startInsertionSort(arrayList, arrayListOSo, chieuSapXep, ViewRootPanel);
                } catch (InterruptedException e) {
                }
            });
            threads[cur].start();
        }
        if (AlgorithmSelected == 2) {
            luongThread++;
            System.out.println(luongThread);
            int cur = luongThread;
            threads[cur] = new Thread(() -> {
                try {
                    startSelectionSort(arrayList, arrayListOSo, chieuSapXep, ViewRootPanel);
                } catch (InterruptedException e) {
                }
            });
            threads[cur].start();
        }
        if (AlgorithmSelected == 3) {
            luongThread++;
            System.out.println(luongThread);
            int cur = luongThread;
            threads[cur] = new Thread(() -> {
                try {
                    startMergeSort(arrayList, arrayListOSo, chieuSapXep, ViewRootPanel, 0, arrayList.size() - 1);
                } catch (InterruptedException e) {
                }
            });
            threads[cur].start();
        }
        if (AlgorithmSelected == 4) {
            luongThread++;
            System.out.println(luongThread);
            int cur = luongThread;
            threads[cur] = new Thread(() -> {
                try {
                    startQuickSort(arrayList, arrayListOSo, chieuSapXep, ViewRootPanel);
                } catch (Exception e) {
                }
            });
            threads[cur].start();
        }
        if (AlgorithmSelected == 5) {
            luongThread++;
            System.out.println(luongThread);
            int cur = luongThread;
            threads[cur] = new Thread(() -> {
                try {
                    startQuickSortBienThe(arrayList, arrayListOSo, chieuSapXep, ViewRootPanel);
                } catch (Exception e) {
                }
            });
            threads[cur].start();
        }
        if (AlgorithmSelected == 6) {
            luongThread++;
            System.out.println(luongThread);
            int cur = luongThread;
            threads[cur] = new Thread(() -> {
                try {
                    startHeapSortNew(arrayList, arrayListOSo, chieuSapXep, ViewRootPanel);
                } catch (Exception e) {
                }
            });
            threads[cur].start();
        }
    }

    public void showArrayOnJPanel_ResetRootJPanel(JPanel ViewRootPanel, LinkedList<Integer> arrayList_1, LinkedList<oSo> arrayListOSo_1, int soLuongGiaiThuat, int firstSelected) {
        ViewRootPanel.removeAll();
        if (!arrayList_1.isEmpty()) {
            JPanel viewer = new viewWithoutCompareJPanel(arrayListOSo_1, ViewRootPanel, firstSelected);

            viewer.setSize(ViewRootPanel.getSize().width, ViewRootPanel.getSize().height);
            ViewRootPanel.removeAll();
            ViewRootPanel.add(viewer);

        }
        ViewRootPanel.validate();
        ViewRootPanel.repaint();
        ViewRootPanel.setVisible(true);
    }

    public void setSourceCode(JPanel controllerSourceCode, DefaultListModel sourceCodeArea, JScrollPane controllerCodeSourceScroll, JList sourceCodeAreaElement, int firstSelected) {
        controllerCodeSourceScroll = new JScrollPane();
        sourceCodeArea = new DefaultListModel<>();
        sourceCodeAreaElement = new JList<>(sourceCodeArea);
        controllerSourceCode.removeAll();
        controllerCodeSourceScroll.setBounds(10, 15, 420, 260);
        //(10, 15, 360, 220)
        controllerSourceCode.add(controllerCodeSourceScroll);
        sourceCodeAreaElement.setBorder(new LineBorder(new Color(0, 0, 0)));
        sourceCodeAreaElement.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        sourceCodeAreaElement.setFont(new Font("Monospaced", Font.BOLD, 14));
        controllerCodeSourceScroll.setViewportView(sourceCodeAreaElement);
        switch (firstSelected) {
            case 0 ->
                listSortController.setBubbleSortSourceCode(controllerSourceCode, sourceCodeArea, controllerCodeSourceScroll, sourceCodeAreaElement);
            case 1 ->
                listSortController.setInsertionSortSourceCode(controllerSourceCode, sourceCodeArea, controllerCodeSourceScroll, sourceCodeAreaElement);
            case 2 ->
                listSortController.setSelectionSortSourceCode(controllerSourceCode, sourceCodeArea, controllerCodeSourceScroll, sourceCodeAreaElement);
            case 3 ->
                listSortController.setMergeSortSourceCode(controllerSourceCode, sourceCodeArea, controllerCodeSourceScroll, sourceCodeAreaElement);
            case 4 ->
                listSortController.setQuickSortSourceCode(controllerSourceCode, sourceCodeArea, controllerCodeSourceScroll, sourceCodeAreaElement);
            case 5 ->
                listSortController.setQuickSortBienTheSourceCode(controllerSourceCode, sourceCodeArea, controllerCodeSourceScroll, sourceCodeAreaElement);
            case 6 ->
                listSortController.setHeapSortSourceCode(controllerSourceCode, sourceCodeArea, controllerCodeSourceScroll, sourceCodeAreaElement);
            default -> {
            }
        }
    }

    public void resetAll(LinkedList<Integer> arrayList_1,
            LinkedList<oSo> arrayListOSo_1,
            int firstAlgorithmSelected,
            JRadioButton[] listJRadioAlgorithmFirst
    ) {
        arrayList_1.clear();
        arrayListOSo_1.clear();

        firstAlgorithmSelected = -1;

        listJRadioAlgorithmFirst = new JRadioButton[new listSort().listSortName.size()];
    }

    public void setProgramState(int state, JPanel controllerSelectAlgorithm, JPanel controllerSortOrder, JPanel controllerControl) {
        switch (state) {
            case 1 -> {
//                controllerSelectAlgorithm.setVisible(false);
                controllerSelectAlgorithm.setVisible(true);
                controllerSortOrder.setVisible(true);
                controllerControl.setVisible(true);
//                controllerSortOrder.setVisible(true);
//                controllerControl.setVisible(true);
            }
            case 2 -> {
                controllerSelectAlgorithm.setVisible(true);
                controllerSortOrder.setVisible(true);
                controllerControl.setVisible(true);
            }
            case 3 -> {
                controllerSelectAlgorithm.setVisible(true);
                controllerSortOrder.setVisible(true);
                controllerControl.setVisible(false);
            }
            case 4 -> {
                controllerSelectAlgorithm.setVisible(true);
                controllerSortOrder.setVisible(true);
                controllerControl.setVisible(true);
            }
            default -> {
            }
        }
    }

    //
    public void startSort(LinkedList<Integer> arrayList, LinkedList<oSo> arrayListOSo, int firstSelected, int chieuSapXep, JPanel ViewRootPanel, JButton controllerControlStartButton) throws InterruptedException {
        luongThread++;
        System.out.println(luongThread);
        int cur = luongThread;
        threads[cur] = new Thread(() -> {
            try {
                if (firstSelected == 1) {
                    originPos_1 = new int[arrayList.size()];
                    for (int i = 0; i < arrayList.size(); i++) {
                        originPos_1[i] = arrayListOSo.get(i).getX();
                    }
                    demSwap1 = 0;
                    callSortFunction_1(arrayList, arrayListOSo, firstSelected, chieuSapXep, ViewRootPanel);
                    while (!isFinished()) {
                    }
                    finishAll();
                    controllerControlStartButton.setEnabled(true);
                    new hoanThanhJDialog().setVisible(true);
                    System.out.print(arrayList);

                } else {
                    
                    //viewWithCompareJPanel.setTimeCompare("Đang chạy");
                    originPos_1 = new int[arrayList.size()];
                    for (int i = 0; i < arrayList.size(); i++) {
                        originPos_1[i] = arrayListOSo.get(i).getX();
                    }
                    demSwap1 = 0;
                    callSortFunction_1(arrayList, arrayListOSo, firstSelected, chieuSapXep, ViewRootPanel);

                    while (!isFinished()) {
                    }
                    finishAll();
                    controllerControlStartButton.setEnabled(true);
                    new hoanThanhJDialog().setVisible(true);
                    System.out.print(arrayList);
                }
            } catch (Exception e) {
            }
        });
        threads[cur].start();
    }

    public void stopSort() {
        for (int i = -1; i <= luongThread; i++) {
            try {
                threads[i].interrupt();
            } catch (Exception e) {
            }
        }
        luongThread = -1;
    }
}

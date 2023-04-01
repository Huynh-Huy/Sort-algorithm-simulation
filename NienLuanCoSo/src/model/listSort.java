/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.LinkedList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Tan Huy
 */
public class listSort {
    
    public LinkedList<String> listSortName = new LinkedList<String>();
    
    public listSort() {
        listSortName.add("Bubble Sort");
        listSortName.add("Insertion Sort");
        listSortName.add("Selection Sort");
        listSortName.add("Merge Sort");
        listSortName.add("Quick Sort");
        listSortName.add("Quick Sort biến thể");
        listSortName.add("Heap Sort");
    }
    
    public void setBubbleSortSourceCode(JPanel controllerCodeSource, DefaultListModel sourceCodeArea, JScrollPane controllerCodeSourceScroll, JList sourceCodeAreaElement) {
        sourceCodeArea.addElement("void BubbleSort(recordtype a[], int n) {");
        sourceCodeArea.addElement("     int i, j;");
        sourceCodeArea.addElement("     for (i = 0 ; i <= n-2 ; i++)");
        sourceCodeArea.addElement("          for (j = n-1; j >= i+1 ; j --)");
        sourceCodeArea.addElement("               if(a[j].key < a[j-1].key)");
        sourceCodeArea.addElement("                    Swap(a[j], a[j-1];");
        sourceCodeArea.addElement("}");
    }
    
    public void setInsertionSortSourceCode(JPanel controllerCodeSource, DefaultListModel sourceCodeArea, JScrollPane controllerCodeSourceScroll, JList sourceCodeAreaElement) {
        sourceCodeArea.addElement("void InsertionSort(recordtype a[], int n) {");
        sourceCodeArea.addElement("     int i, j;");
        sourceCodeArea.addElement("     for(i = 1; i <= n-1; i++) {");
        sourceCodeArea.addElement("          j = i;");
        sourceCodeArea.addElement("          while ((j > 0) && (a[j].key < a[j-1].key)) {");
        sourceCodeArea.addElement("               Swap(a[j], a[j-1];");
        sourceCodeArea.addElement("               j--;");
        sourceCodeArea.addElement("          }");
        sourceCodeArea.addElement("     }");
        sourceCodeArea.addElement("}");
    }
    
    public void setSelectionSortSourceCode(JPanel controllerCodeSource, DefaultListModel sourceCodeArea, JScrollPane controllerCodeSourceScroll, JList sourceCodeAreaElement) {
        sourceCodeArea.addElement("void SelectionSort(recordtype a[], int n) {");
        sourceCodeArea.addElement("     int lowindex,i,j;");
        sourceCodeArea.addElement("     keytype lowkey;");
        sourceCodeArea.addElement("     for (i=0; i <= n-2 ; i++) {");
        sourceCodeArea.addElement("          lowkey = a[i].key;");
        sourceCodeArea.addElement("          lowindex = i;");
        sourceCodeArea.addElement("          for(j = i+1; j <= n+1 ; j++)");
        sourceCodeArea.addElement("               if (a[j].keyn < lowkey){");
        sourceCodeArea.addElement("                    lowkey= a[j].key;");
        sourceCodeArea.addElement("                    lowindex = j;");
        sourceCodeArea.addElement("               }");
        sourceCodeArea.addElement("          Swap(a[i],a[lowindex]);");
        sourceCodeArea.addElement("     }");
        sourceCodeArea.addElement("}");
    }
    
    public void setMergeSortSourceCode(JPanel controllerCodeSource, DefaultListModel sourceCodeArea, JScrollPane controllerCodeSourceScroll, JList sourceCodeAreaElement) {
        sourceCodeArea.addElement("void MergeSort(int left, int right) {");
        sourceCodeArea.addElement("    if (left < right) {");
        sourceCodeArea.addElement("        int mid = (left + right) / 2;");
        sourceCodeArea.addElement("        MergeSort(left, mid);");
        sourceCodeArea.addElement("        MergeSort(mid + 1, right);");
        sourceCodeArea.addElement("        Merge(left, mid, right);");
        sourceCodeArea.addElement("    }");
        sourceCodeArea.addElement("}");
        sourceCodeArea.addElement("");
        sourceCodeArea.addElement("public void Merge(int left, int mid, int right) {");
        sourceCodeArea.addElement("    int n1 = mid - left + 1;");
        sourceCodeArea.addElement("    int n2 = right - mid;");
        sourceCodeArea.addElement("    int[] T = new int[n1 + n2];");
        sourceCodeArea.addElement("    int[] L = new int[n1];");
        sourceCodeArea.addElement("    int[] R = new int[n2];");
        sourceCodeArea.addElement("    int i, j, k;");
        sourceCodeArea.addElement("    for (i = 0; i < n1; i ++)");
        sourceCodeArea.addElement("        L[i] = array[left + i];");
        sourceCodeArea.addElement("    for (j = 0; j < n2; j ++)");
        sourceCodeArea.addElement("        R[j] = array[mid + 1 + j];");
        sourceCodeArea.addElement("    i = 0; j = 0;");
        sourceCodeArea.addElement("    k = left;");
        sourceCodeArea.addElement("    while (i < n1 && j < n2) {");
        sourceCodeArea.addElement("        if (L[i] <= R[j]) {");
        sourceCodeArea.addElement("            array[k] = L[i];");
        sourceCodeArea.addElement("            i ++;");
        sourceCodeArea.addElement("        } else {");
        sourceCodeArea.addElement("            array[k] = R[j];");
        sourceCodeArea.addElement("            j ++;");
        sourceCodeArea.addElement("        }");
        sourceCodeArea.addElement("        k ++;");
        sourceCodeArea.addElement("    }");
        sourceCodeArea.addElement("    while (i < n1) {");
        sourceCodeArea.addElement("        array[k] = L[i];");
        sourceCodeArea.addElement("        i ++;");
        sourceCodeArea.addElement("        k ++;");
        sourceCodeArea.addElement("    }");
        sourceCodeArea.addElement("    while (j < n2) {");
        sourceCodeArea.addElement("        array[k] = R[j];");
        sourceCodeArea.addElement("        j ++;");
        sourceCodeArea.addElement("        k ++;");
        sourceCodeArea.addElement("    }");
        sourceCodeArea.addElement("}");
    }
    
    public void setQuickSortSourceCode(JPanel controllerCodeSource, DefaultListModel sourceCodeArea, JScrollPane controllerCodeSourceScroll, JList sourceCodeAreaElement) {
        sourceCodeArea.addElement("void QuickSort(int a[], int left, int right) {");
        sourceCodeArea.addElement("     int i, j, x;");
        sourceCodeArea.addElement("     x = a[(left+right)/2];");
        sourceCodeArea.addElement("     i = left; j = right;");
        sourceCodeArea.addElement("     while(i < j) {");
        sourceCodeArea.addElement("          while(a[i] < x) i++;");
        sourceCodeArea.addElement("          while(a[j] >= x) j--;");
        sourceCodeArea.addElement("          if(i <= j) {");
        sourceCodeArea.addElement("               Swap(a[i],a[j]);");
        sourceCodeArea.addElement("               i++ ; j--;");
        sourceCodeArea.addElement("          }");
        sourceCodeArea.addElement("     }");
        sourceCodeArea.addElement("     if(left<j)");
        sourceCodeArea.addElement("          QuickSort(a, left, j)");
        sourceCodeArea.addElement("     if(i<right)");
        sourceCodeArea.addElement("          QuickSort(a, i, right);");
        sourceCodeArea.addElement("}");
    }
    
    public void setQuickSortBienTheSourceCode(JPanel controllerCodeSource, DefaultListModel sourceCodeArea, JScrollPane controllerCodeSourceScroll, JList sourceCodeAreaElement) {
        sourceCodeArea.addElement("void QuickSortBienThe(int a[], int left, int right) {");
        sourceCodeArea.addElement("     int i, j, x;");
        sourceCodeArea.addElement("     x = a[(int)(Math.random() * ((max - min) + 1)) + min];");
        sourceCodeArea.addElement("     i = left; j = right;");
        sourceCodeArea.addElement("     while(i < j) {");
        sourceCodeArea.addElement("          while(a[i] <= x) i++;");
        sourceCodeArea.addElement("          while(a[j] > x) j--;");
        sourceCodeArea.addElement("          if(i <= j) {");
        sourceCodeArea.addElement("               Swap(a[i],a[j]);");
        sourceCodeArea.addElement("               i++ ; j--;");
        sourceCodeArea.addElement("          }");
        sourceCodeArea.addElement("     }");
        sourceCodeArea.addElement("     if(left<j)");
        sourceCodeArea.addElement("          QuickSort(a, left, j)");
        sourceCodeArea.addElement("     if(i<right)");
        sourceCodeArea.addElement("          QuickSort(a, i, right);");
        sourceCodeArea.addElement("}");
    }
    
    public void setHeapSortSourceCode(JPanel controllerCodeSource, DefaultListModel sourceCodeArea, JScrollPane controllerCodeSourceScroll, JList sourceCodeAreaElement) {
        sourceCodeArea.addElement("void HeapSort(recordtype a[], int n) {");
        sourceCodeArea.addElement("     int i;");
        sourceCodeArea.addElement("     for(i = (n-2)/2; i>=0; i--)");
        sourceCodeArea.addElement("         PushDown(a,i,n-1);");
        sourceCodeArea.addElement("     for(i = n-1; i>=2; i--) {");
        sourceCodeArea.addElement("          Swap(a[0],a[i]);");
        sourceCodeArea.addElement("          PushDown(a, 0, i-1);");
        sourceCodeArea.addElement("     }");
        sourceCodeArea.addElement("     Swap(a[0],a[1]);");
        sourceCodeArea.addElement("}");
        sourceCodeArea.addElement("");
        sourceCodeArea.addElement("void PushDown(recordtype a[], int first,int last){");
        sourceCodeArea.addElement("     int r= first;");
        sourceCodeArea.addElement("     while (r <= (last-1)/2)");
        sourceCodeArea.addElement("         if (last == 2*r+1) {");
        sourceCodeArea.addElement("             if (a[r].key > a[last].key) Swap(a[r],a[last]);");
        sourceCodeArea.addElement("             r = last;");
        sourceCodeArea.addElement("         } else");
        sourceCodeArea.addElement("         if ((a[r].key>a[2*r+1].key) && (a[2*r+1].key<=a[2*r+2].key){");
        sourceCodeArea.addElement("             Swap(a[r],a[2*r+1]);");
        sourceCodeArea.addElement("             r = 2*r+1 ;");
        sourceCodeArea.addElement("         } else");
        sourceCodeArea.addElement("         if ((a[r].key>a[2*r+2].key) && (a[2*r+2].key<a[2*r+1].key)){");
        sourceCodeArea.addElement("             Swap(a[r],a[2*r+2]);");
        sourceCodeArea.addElement("             r = 2*r+2 ;");
        sourceCodeArea.addElement("         } else");
        sourceCodeArea.addElement("         r = last;");
        sourceCodeArea.addElement("}");
    }

    
}

package randomprograms;

public class ArrayIntersection {
	public static void main(String[] args) {
		int[] a= {1,2,3,8,9,8,4};
		int[] b= {6,8,9,9,10,2};
		
		int count = a.length;
		int k=0,q=0;
		int[] c= new int[count];
		for (int i=0;i<a.length;i++) {
			for(int j=0;j<b.length;j++) {
				if (a[i]==b[j]) {
					c[q]=b[j];
					q++;
				}
			}
		}
		for (int i = 0; i <= count; i++) { 
			int m = i + 1;
			while (m < temp) { 
				if (c[i]==c[m]) {
					break;
				}
				m++; 
			}
			if(m==k) {
				System.out.println(c[i]);
			}
		}
	
	}
}
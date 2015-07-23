package test;

public class BubbleSort {
	
	public static void bubblesort(int[] array)
	{
		for(int i = 0; i < array.length-1; i++)
		{
			for(int j = 0; j < array.length - 1 - i; j++)
			{
				if(array[j] > array[j+1])
				{
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
			
			System.out.println("第" + (i+1) + "趟排序结果为：");
			for(int k = 0; k < array.length; k++)
			{
				System.out.print(array[k] + " ");
			}
			System.out.println();
		}	
	}
	
	public static void main(String[] args) {
		int[] a = {2, 4, 1, 8, 0, 3, 9, 5};
		bubblesort(a);
		
	}

}

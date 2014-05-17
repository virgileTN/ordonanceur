package ordonnanceur;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class TriOrdonnanceur extends AbstractOrdonnanceur{
	
	public TriOrdonnanceur(int nbCoeur) {
		super(nbCoeur);
	}
	
	protected List<Task> getOrderedList(TaskList list) {
		List<Task> ordered = new ArrayList<Task>(list.getSize());
		
		for(int i = 0; i < list.getSize(); i++) {
			ordered.add(new Task(list.getTask(i)));
		}
		
		quickSort(ordered, 0, ordered.size()-1);
		
		return ordered;
	}
	
	private void quickSort(List<Task> list, int begin, int end) {
		if(end - begin < 12)
			insertionSort(list, begin, end);
		else {
			int pivot = getPivot(list, begin, end);
			pivot = partition(list, begin, end, pivot);
			quickSort(list, begin, pivot-1);
			quickSort(list, pivot+1, end);
		}
	}
	
	private int getPivot(List<Task> list, int begin, int end) {
		Random rand = new Random();
		
		return rand.nextInt(end - begin) + begin;
	}
	
	private void echanger(List<Task> list, int e1, int e2) {
		Task buffer = list.get(e1);
		list.set(e1, list.get(e2));
		list.set(e2, buffer);
	}
	
	private int partition(List<Task> list, int begin, int end, int pivot) {
		echanger(list, pivot, end);
		int j = begin;
		for(int i = begin; i < end; i++) {
			if(isSup(list.get(i), list.get(end))) {
				echanger(list, i, j);
				j++;
			}
		}
		echanger(list, end, j);
		
		return j;
	}
	
	private void insertionSort(List<Task> list, int begin, int end) {
		for(int i = begin + 1; i <= end; i++) {
			Task x = list.get(i);
			int pos = 1;
			for(int j = i; j > 1; j--) {
				if(isSup(x, list.get(j - 1))) {
					pos = j;
					break;
				}
				list.set(j, list.get(j - 1));
			}
			list.set(pos, x);
		}
	}
	
	protected abstract boolean isSup(Task t1, Task t2);
}

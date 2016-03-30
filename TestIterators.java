import iterators.Iterators;
import iterators.Predicate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestIterators {
	public static void main(String[] args) {
		List<Integer> li = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			li.add(new Integer(i));
		}

		Iterator<Integer> it = Iterators.iteratorWithPredicate(li.iterator(),
				new Predicate<Integer>() {

					public boolean predicate(Integer i) {
						return i % 3 == 0;
					}
				});

		Iterators.print(it, " ");
		
		Iterators.print(Iterators.append(li.iterator(), li.iterator()), " ");
	}

}

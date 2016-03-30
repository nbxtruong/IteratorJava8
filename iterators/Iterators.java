package iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Iterators {
	public static <E> Iterator<E> iteratorWithPredicate(
			final Iterator<? extends E> iterator, final Predicate<? super E> p) {
		return new Iterator<E>() {

			private E next = null;

			public boolean hasNext() {
				while (next == null) {
					if (!iterator.hasNext()) {
						return false;
					}
					next = iterator.next();
					if (!p.predicate(next)) {
						next = null;
					}
				}
				return true;
			}

			public E next() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				E n = next;
				next = null;
				return n;
			}

//			public void remove() {
//				throw new UnsupportedOperationException();
//			}
		};
	}

	public static <E> Iterator<E> append(final Iterator<? extends E> it1,
			final Iterator<? extends E> it2) {
		return new Iterator<E>() {
			private boolean first = true;

			public boolean hasNext() {
				return it1.hasNext() || it2.hasNext();
			}

			public E next() {
				if (it1.hasNext()) {
					return it1.next();
				} else {
					first = false;
					return it2.next();
				}
			}

			public void remove() {
				if (first) {
					it1.remove();
				} else {
					it2.remove();
				}
			}
		};
	}

	public static void print(Iterator<?> it, String separator) {
		while (it.hasNext()) {
			System.out.print(it.next() + (it.hasNext() ? separator : ""));
		}
		System.out.println();
	}
}

package com.rankingEnZymes.controller;

import java.util.Comparator;

import com.rankingEnZymes.model.FinalCAZymes.ResponseObj;

public class CompareObj implements Comparable<ResponseObj> {

	@Override
	public int compareTo(ResponseObj o) {
		// TODO Auto-generated method stub
		return 0;
	}

	static class ClassifierComparator implements Comparator<ResponseObj> {
		public int compare(ResponseObj p1, ResponseObj p2) {
			Long obj1 = p1.getClassifier();
			Long obj2 = p2.getClassifier();
			int retval = obj1.compareTo(obj2);
			if (retval > 0) {
				return 1;
			} else if (retval < 0) {
				return -1;
			} else {
				return 0;
			}
		}

	}

}

﻿using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace HW1_CSharp
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void TestEmptyArr() //array is empty, expected to be the same after sort
        {
            int[] arr = { };
            int[] expected = { };
            HeapSortClass.HeapSort(arr);
            CollectionAssert.AreEqual(expected, arr);
        }

        [TestMethod]
        [ExpectedException(typeof(NullReferenceException))]
        public void TestNullArr() //array is null, NullReferenceException expected to be thrown
        {
            HeapSortClass.HeapSort(null);
            Assert.Fail("Exception hasn't been thrown");
        }

        [TestMethod]
        public void TestAllZeroArr() //array contains only 0, expected to be the same after sort
        {
            int[] arr = new int[]{0,0,0,0};
            int[] expected = new int[]{0,0,0,0};
            HeapSortClass.HeapSort(arr);
            CollectionAssert.AreEqual(expected, arr);
        }

        [TestMethod]
        public void TestSortedArr() //array is already sorted, expected to be the same after sort
        {
            int[] arr = new int[] { 1, 2, 3, 4 };
            int[] expected = new int[] { 1, 2, 3, 4 };
            HeapSortClass.HeapSort(arr);
            CollectionAssert.AreEqual(expected, arr, "Arrays are different");
        }

        [TestMethod]
        public void TestNegativeArr() //array contains only negative ints, expected to be sorted after sort
        {
            int[] arr = new int[] { -2, -1, -3, -4 };
            int[] expected = new int[] { -4, -3, -2, -1 };
            HeapSortClass.HeapSort(arr);
            CollectionAssert.AreEqual(expected, arr, "Can't sort negative");
        }

        [TestMethod]
        public void TestNegativeAndPositiveArr() //array contains only negatives and positives ints, expected to be sorted after sort
        {
            int[] arr = new int[] { -2, 1, -3, 4 };
            int[] expected = new int[] { -3, -2, 1, 4 };
            HeapSortClass.HeapSort(arr);
            CollectionAssert.AreEqual(expected, arr, "Can't sort negative&positive");
        }

        [TestMethod]
        public void TestPositiveArr() //array contains only positive ints, expected to be sorted after sort
        {
            int[] arr = new[] { 3, 4, 5, 1 };
            int[] expected = new[] { 1, 3, 4, 5 };
            HeapSortClass.HeapSort(arr);
            CollectionAssert.AreEqual(expected, arr, "Arr not equal to expected");
        }
    }
}
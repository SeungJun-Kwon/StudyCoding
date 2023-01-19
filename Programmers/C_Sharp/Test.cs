using System;
using System.Collections;

public class Class1
{
	string s1, s2;
	Queue<int, int> q = new Queue<int, int>;

	void abc()
	{
		q.Enqueue(0, 1);
		q.Enqueue();
	}
}

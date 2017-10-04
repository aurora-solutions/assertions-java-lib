# Assertions

It allows you to de-couple assertions from your test cases. You can swap any assertion library by changing just 1 line of code. `Assertions` follows a pattern that makes writing test cases easily, and in a proper structed way and your test case classes(client side) are made simple. For example if you want to test the following class:

```
public class Point {
    public int x;
    public int y;
    public Point() {
    }
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public boolean isSame(Point point) {
        return point.x == y && point.y == y;
    }
}
```

We can create a Tester class that will handle test cases for the above class like below

```
public class PointTester extends AssertionsProxy implements ClassTester<PointTester> {
    public PointTester forConstructor(Object... values) {
        Point point = new Point((int)values[0], (int)values[1]);
        // You can use this method to tell what needs to be asserted
        super.setResult(point.x, point.y);
    }
    
    public PointTester forIsSame(Point actualPoint, Point argument) {
        super.setResult(actualPoint.isSame(argument));
    }
}
```

Now on the test case we can perform tests like the following:
```
@Test
public void constructorTest() throws Exception {
    new PointTester()
        .forConstructor(3, 4)
        .isEqualTo(3, 4)
        .doAssert();
}

@Test
public void constructorTest() throws Exception {
    new PointTester()
        .forIsSame(new Point(3, 4), new Point(5, 6))
        .isFalse()
        .doAssert();
}
```

This is helpful for testing complex classes when you have a lot of prerequisites for object creation etc.

The tester class created like this will allow you to assert with the following cases:

1. isEqualTo(Object... expected)
2. isTrue()
3. isFalse()
4. throwsException(Class expectedException)

Followed by `doAssert()` to perform assertion.

It uses AssertJ assertions by default. So if you want to change assertions library, you can create a new class from `AssertionsBase` and override `doAssert` method and check using `assertionType` enum for the type of assertion you need to add. And then you can implement a new `AssertionFactory` using the interface and pass in that factory to the constructor of `AssertionsProxy` and that'll do the trick.
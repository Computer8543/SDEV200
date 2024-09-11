/* Program name: Rational.java
 * Author: Kyle Ingersoll
 * Date last updated: 9/11/2024
 * Purpose: To reimplement the Rational class using BigInteger data type instead of long data type.
 */

import java.math.BigInteger; // for BigInteger data type

public class Rational extends Number implements Comparable<Rational> {
    // Data fields for numerator and denominator
    private BigInteger numerator = new BigInteger("0");
    private BigInteger denominator = new BigInteger("1");
  
    /** Construct a rational with default properties */
    public Rational() {
        this(new BigInteger("0"), new BigInteger("1"));
    }
  
    /** Construct a rational with specified numerator and denominator */
    public Rational(BigInteger numerator, BigInteger denominator) {
        BigInteger gcd = gcd(numerator, denominator);
      
        // the denominator is compared to see if it is greater than 0, if so the numerator is 1, if not it is -1.
        // then we multiply by the numerator and divide by gcd
        this.numerator = (denominator.compareTo(new BigInteger("0")) > 0  ? new BigInteger("1") : new BigInteger("-1")).multiply(numerator).divide(gcd);
        this.denominator = denominator.abs().divide(gcd);
    }
  
    /** Find GCD of two numbers */
    private static BigInteger gcd(BigInteger n, BigInteger d) {
        // n1 and n2 are the absolute values of n and d respectively, and gcd begins at 1.
        BigInteger n1 = n.abs();
        BigInteger n2 = d.abs();
        BigInteger gcd = new BigInteger("1");
    
        // what this loop is doing is that it checks for the greatest common divisor
        for (BigInteger k = new BigInteger("1"); k.compareTo(n1) <= 0 && k.compareTo(n2) <= 0; k = k.add(new BigInteger("1"))) {
            if (n1.mod(k).equals(new BigInteger("0")) && n2.mod(k).equals(new BigInteger("0"))) 
            gcd = k;
        }
    
        return gcd;
    }
  
    /** Return numerator */ 
    public BigInteger getNumerator() {
      return numerator;
    }
  
    /** Return denominator */
    public BigInteger getDenominator() {
      return denominator;
    }
  
    /** Add a rational number to this rational */
    public Rational add(Rational secondRational) {
      BigInteger n = (numerator.multiply(secondRational.getDenominator())).add(denominator.multiply(secondRational.getNumerator()));
      BigInteger d = denominator.multiply(secondRational.getDenominator());
      return new Rational(n, d);
    }
  
    /** Subtract a rational number from this rational */
    public Rational subtract(Rational secondRational) {
      BigInteger n = (numerator.multiply(secondRational.getDenominator())).subtract(denominator.multiply(secondRational.getNumerator()));
      BigInteger d = denominator.multiply(secondRational.getDenominator());
      return new Rational(n, d);
    }
  
    /** Multiply a rational number to this rational */
    public Rational multiply(Rational secondRational) {
      BigInteger n = numerator.multiply(secondRational.getNumerator());
      BigInteger d = denominator.multiply(secondRational.getDenominator());
      return new Rational(n, d);
    }
  
    /** Divide a rational number from this rational */
    public Rational divide(Rational secondRational) {
      BigInteger n = numerator.multiply(secondRational.getDenominator());
      BigInteger d = denominator.multiply(secondRational.getNumerator());
      return new Rational(n, d);
    }
  
    @Override // Override toString()
    public String toString() {
      if (denominator.equals(new BigInteger("1")))
        return numerator.toString() + "";
      else
        return numerator.toString() + "/" + denominator.toString();
    }
  
    @Override // Override the equals method in the Object class 
    public boolean equals(Object other) {
      if ((other instanceof Rational) && (this.subtract((Rational)(other))).getNumerator().equals(new BigInteger("0")))
        return true;
      else
        return false;
    }
  
    @Override // Implement the abstract intValue method in Number 
    public int intValue() {
      return (int)doubleValue();
    }
  
    @Override // Implement the abstract floatValue method in Number 
    public float floatValue() {
      return (float)doubleValue();
    }
  
    @Override // Implement the doubleValue method in Number 
    public double doubleValue() {
      return numerator.doubleValue() * 1.0 / denominator.doubleValue();
    }
  
    @Override // Implement the abstract BigIntegerValue method in Number
    public long longValue() {
      return (long)doubleValue();
    }
  
    @Override // Implement the compareTo method in Comparable
    public int compareTo(Rational o) {
      if (this.subtract(o).getNumerator().compareTo(new BigInteger("0")) > 0)
        return 1;
      else if (this.subtract(o).getNumerator().compareTo(new BigInteger("0")) < 0)
        return -1;
      else
        return 0;
    }
  }

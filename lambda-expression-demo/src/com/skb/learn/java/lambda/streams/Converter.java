package com.skb.learn.java.lambda.streams;

@FunctionalInterface
// This interface is very much similar to Function FI defined in java.util.function
interface Converter<F, T> {
  // will convert F type to T type
  T convert(F from);
}

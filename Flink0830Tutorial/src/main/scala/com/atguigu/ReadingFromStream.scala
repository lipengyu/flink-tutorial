package com.atguigu

import org.apache.flink.api.common.functions.{FilterFunction, MapFunction}
import org.apache.flink.streaming.api.scala._

object ReadingFromStream {
  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    env.setParallelism(1)
    val stream = env.addSource(new SensorSource)

    // DataStream -> DataStream

    // 匿名函数来实现map算子
    // stream.map(r => r.id).print()

    // 使用接口的方式来实现map算子
    // stream.map(new MyMapFunction).print()

    // 使用匿名函数来实现filter算子
    // stream.filter(r => r.temperature > 0).print()

    // 使用接口的方式来实现filter算子
    stream.filter(new MyFilterFunction).print()

    env.execute()
  }

  class MyMapFunction extends MapFunction[SensorReading, String] {
    override def map(t: SensorReading): String = t.id
  }

  class MyFilterFunction extends FilterFunction[SensorReading] {
    override def filter(value: SensorReading): Boolean = value.temperature > 0
  }
}
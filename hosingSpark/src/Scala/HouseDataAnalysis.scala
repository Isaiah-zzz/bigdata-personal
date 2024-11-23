import org.apache.spark.sql.SparkSession

object HouseDataAnalysis {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("HouseDataAnalysis")
      .master("local[*]")
      .getOrCreate()

    val df = spark.read
      .option("header", true)
      .csv("/Users/zhoucy/Downloads/bigdata/housingSpark/datas/sh_data.csv")

    println("total house price info：")
    val totalDF = df.select("total_price").describe()
    totalDF.show()

    println("decor info：")
    val decorationDF = df.select("decoration").na.drop("any").groupBy("decoration").count()
    decorationDF.show()

    println("with/without elevator：")
    val elevatorDF = df.select("elevator").na.drop("any").groupBy("elevator").count()
    elevatorDF.show()

    println("housing in different area：")
    val districtDF = df.select("district").na.drop("any").groupBy("district").count()
    districtDF.show()

    spark.stop()
  }
}
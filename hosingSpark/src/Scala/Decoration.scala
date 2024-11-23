import org.apache.spark.sql.{SaveMode, SparkSession}
object Decoration{
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("HouseDataAnalysis")
      .master("local[*]")
      .getOrCreate()

//    val df = spark.read.option("header", true).csv("hdfs://34.122.153.173:9870/sh_data.csv")
    val df = spark.read.option("header", true).csv("/Users/zhoucy/Downloads/bigdata/housingSpark/datas/sh_data.csv")

    val decorationDF = df.select("decoration").na.drop("any").groupBy("decoration").count()
    decorationDF.show()
    val url = "jdbc:mysql://localhost:3306/house"
    val user = "root"
    val password = "zcy2551616"

    decorationDF.write
      .mode(SaveMode.Overwrite)
      .jdbc(url, "decoration", new java.util.Properties() {
        {
          put("user", user)
          put("password", password)
        }
      })
    spark.stop()
  }
}

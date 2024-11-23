import org.apache.spark.sql.{SaveMode, SparkSession}
// total house prices
object Total{
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("HouseDataAnalysis")
      .master("local[*]")
      .getOrCreate()

    val df = spark.read.option("header", true).csv("/Users/zhoucy/Downloads/bigdata/housingSpark/datas/sh_data.csv")

    println("total house price：")
    val totalDF = df.select("total_price").describe()
    totalDF.show()

    val url = "jdbc:mysql://localhost:3306/house"
    val user = "root"
    val password = "zcy2551616"

    totalDF.write.mode(SaveMode.Overwrite)
      .jdbc(url, "total", new java.util.Properties() {
        {
          put("user", user)
          put("password", password)
        }
      })
    spark.stop()
  }
}

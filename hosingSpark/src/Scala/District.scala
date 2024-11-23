import org.apache.spark.sql.{SaveMode, SparkSession}
object District{
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("HouseDataAnalysis")
      .master("local[*]")
      .getOrCreate()

    val df = spark.read
      .option("header", true)
      .csv("/Users/zhoucy/Downloads/bigdata/housingSpark/datas/sh_data.csv")

    println("District housing spread：")
    val districtDF = df.select("district").na.drop("any").groupBy("district").count()
    districtDF.show()

    val url = "jdbc:mysql://localhost:3306/house"
    val user = "root"
    val password = "zcy2551616"

    districtDF.write
      .mode(SaveMode.Overwrite)
      .jdbc(url, "district", new java.util.Properties() {
        {
          put("user", user)
          put("password", password)
        }
      })

    spark.stop()
  }
}

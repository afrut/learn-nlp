import org.apache.spark.sql.SparkSession
object Main {
  def main(args: Array[String]){
    val spark = SparkSession.builder().appName("Test").getOrCreate()

    val filepath = "..\\data\\mini_newsgroups\\"
    val texts = spark.sparkContext.wholeTextFiles(filepath).toDF(schema = schema)
    val schema = StructType([StructField("filename", StringType())
      ,StructType("text", StringType())])

    texts.show()

    spark.stop()
  }
}
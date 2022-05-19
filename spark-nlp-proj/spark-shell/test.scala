import org.apache.spark.sql.types.{StructType, StructField, StringType}

val filepath = "..\\data\\mini_newsgroups\\*"
val texts_df = spark.sparkContext.wholeTextFiles(filepath).toDF("filename", "text")
texts_df.show()
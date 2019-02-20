learning mongoDB - using in-memory mongoDB but have also signed up for free MongoDB Atlas cluster https://cloud.mongodb.com/v2/5c6d71bf9ccf64454514b048#clusters?fastPoll=true

started to change it to be based on this...
https://www.youtube.com/watch?v=l5KC6OcbuOI&t=370s

nothing to it really - same as JPA - have a MongoDBRepository which provides all the usual methods such as findAll()
then it's a case of using @Document rather than @Entity

not got this working properly yet - I think the in-memory database is stopped by the time I call the rest endpoint
 - will try to point to the Atlas version instead


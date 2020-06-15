CREATE TABLE IF NOT EXISTS products (id UUID PRIMARY KEY,name text,description text, price decimal, created timestamp);
CREATE TABLE IF NOT EXISTS timeseries_daily (source text,yyyymmdd text, tick timestamp, value double, PRIMARY KEY ((source,yyyymmdd), tick)) WITH CLUSTERING ORDER BY (tick DESC);

INSERT INTO betterbotz.products ( id , name , description, price, created ) VALUES (31047029-2175-43ce-9fdd-b3d568b19bb0,'Heavy Lift Arms', 'Heavy lift arms capable of lifting 1,250 lbs of weight per arm. Sold as a set.',4199.99,'2019-01-10 09:48:31.020+0040');
INSERT INTO betterbotz.products ( id , name , description, price, created ) VALUES (31047029-2175-43ce-9fdd-b3d568b19bb1,'Precision Action Arms','Arms for precision activities in manufacturing or repair. Sold as a set.',12199.99,'2019-01-10 09:28:31.020+0040');
INSERT INTO betterbotz.products ( id , name , description, price, created ) VALUES (31047029-2175-43ce-9fdd-b3d568b19bb2,'Medium Lift Arms','Medium lift arms capable of lifting 850 lbs of weight per arm. Sold as a set.',3199.99,'2019-01-10 09:23:31.020+0040');
INSERT INTO betterbotz.products ( id , name , description, price, created ) VALUES (31047029-2175-43ce-9fdd-b3d568b19bb3,'Drill Arms','Arms for drilling into surface material. Sold as a set. Does not include drill bits.',2199.99,'2019-01-10 09:12:31.020+0040');
INSERT INTO betterbotz.products ( id , name , description, price, created ) VALUES (31047029-2175-43ce-9fdd-b3d568b19bb4,'High Process AI CPU','Head processor unit for robot with heavy AI job process capabilities.',2199.99,'2019-01-10 18:48:31.020+0040');
INSERT INTO betterbotz.products ( id , name , description, price, created ) VALUES (31047029-2175-43ce-9fdd-b3d568b19bb5,'Basic Task CPU','Head processor unit for robot with basic process tasks.',899.99,'2019-01-10 18:48:31.020+0040');
INSERT INTO betterbotz.products ( id , name , description, price, created ) VALUES (31047029-2175-43ce-9fdd-b3d568b19bb6,'High Strength Torso','Robot body with reinforced plate to handle heavy workload and weight during jobs.',2199.99,'2019-01-10 18:48:31.020+0040');
INSERT INTO betterbotz.products ( id , name , description, price, created ) VALUES (31047029-2175-43ce-9fdd-b3d568b19bb7,'Medium Strength Torso','Robot body to handle general jobs.',1999.99,'2019-01-10 18:48:31.020+0040');
INSERT INTO betterbotz.products ( id , name , description, price, created ) VALUES (31047029-2175-43ce-9fdd-b3d568b19bb8,'Precision Torso','Robot torso built to handle precision jobs with extra stability and accuracy reinforcement.',8199.99,'2019-01-10 18:48:31.020+0040');

INSERT INTO betterbotz.timeseries_daily (source , yyyymmdd , tick, value) VALUES ('sensor_X','20200501',1590084479687,0.1);
INSERT INTO betterbotz.timeseries_daily (source , yyyymmdd , tick, value) VALUES ('sensor_X','20200501',1590084479688,0.2);
INSERT INTO betterbotz.timeseries_daily (source , yyyymmdd , tick, value) VALUES ('sensor_X','20200501',1590084479689,0.5);
INSERT INTO betterbotz.timeseries_daily (source , yyyymmdd , tick, value) VALUES ('sensor_X','20200501',1590084479690,0.5);

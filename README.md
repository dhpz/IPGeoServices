# IPGeoServices

Implements a remote service that lets you get the user country ISO, based on 
its IP address.

## Where to get the database files

Visit this page:
[geolite2](http://dev.maxmind.com/geoip/geoip2/geolite2/)

Download the GeoLite2 City CSV format file. This file contains the necessary 
locations and blocks databases.

## Server configuration

Since the blocks csv file is larger than 100MB it will be necessary to up the 
maximun file upload size. Go to Control Panel -> Server Administration -> File Uploads, 
and modify the "Overall Maximum File Size" property.

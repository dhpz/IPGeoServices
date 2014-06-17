create table rivetlogic_geo_GeoBlocks (
	geonameId LONG not null,
	startIp LONG not null,
	endIp LONG,
	primary key (geonameId, startIp)
);

create table rivetlogic_geo_GeoLocations (
	geonameId LONG not null primary key,
	countryIsoCode VARCHAR(75) null
);
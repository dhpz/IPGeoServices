create table rivetlogic_geoip_GeoipBlocks (
	geonameId LONG not null,
	startIp LONG not null,
	endIp LONG,
	primary key (geonameId, startIp)
);

create table rivetlogic_geoip_GeoipLocations (
	geonameId LONG not null primary key,
	countryIsoCode VARCHAR(75) null
);
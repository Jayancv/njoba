INSERT INTO  ad_type ( type_id ,  type_code ,  type_name ) VALUES (00001,'BASIC', 'Basic Advertisments');
INSERT INTO  ad_type ( type_id ,  type_code ,  type_name ) VALUES (00010,'BANNER', 'Banner Advertisments');
INSERT INTO  ad_type ( type_id ,  type_code ,  type_name ) VALUES (00100,'CUSTOM', 'Custom Advertisments');
INSERT INTO  ad_type ( type_id ,  type_code ,  type_name ) VALUES (01000,'SECTOR', 'Sector Advertisments');
INSERT INTO  ad_type ( type_id ,  type_code ,  type_name ) VALUES (10000,'VIDEO', 'Video Advertisments');

INSERT INTO  souvenir ( souvenir_id ,  description ,  souvenir_code ,  souvenir_name ,  year , active ,  visibility )
VALUES (1,'2020','2020','2020','2020',1,1);

INSERT INTO  selling_unit ( unit_id ,  cost , price ,   remain_count ,  units )
VALUES ( 1,500,1000,10,10);
INSERT INTO  selling_unit ( unit_id ,  cost , price ,   remain_count ,  units )
VALUES ( 2,1000,1500,15,15);
INSERT INTO  selling_unit ( unit_id ,  cost , price ,   remain_count ,  units )
VALUES ( 3,1000,1500,15,15);

INSERT INTO  product_type ( product_id ,  description ,  product_code ,  product_name ,  ad_type_id ,  selling_unit_id , souvenir_id )
VALUES (1,'Black & White','BASCI_B&W','Black & White',00001,1,1);
INSERT INTO  product_type ( product_id ,  description ,  product_code ,  product_name ,  ad_type_id ,  selling_unit_id , souvenir_id )
VALUES (2,'colour','BASCI_COLOUR','Color',00001,2,1);
INSERT INTO  product_type ( product_id ,  description ,  product_code ,  product_name ,  ad_type_id ,  selling_unit_id , souvenir_id )
VALUES (3,'10x4 colour banner','COLOUR1','Color 1',00010,3,1);
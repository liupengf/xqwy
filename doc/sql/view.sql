create or replace view v_tjbb  as 
select tslb as name,count(*) as con ,'ts' as lb from xqwy_ts group by tslb
union all
select bxlb as name, count(*) as con,'bx' as lb from xqwy_bx group by bxlb;
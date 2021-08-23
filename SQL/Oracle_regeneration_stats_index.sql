-- Invocation from SQL Developper :
-- @{PATH}\regeneration_stats_index.sql

-- Script permettant de générer le calcul des statistiques pour l'ensemble des tables d'un schema
SET ECHO OFF;
SET FEEDBACK OFF;
SET SERVEROUTPUT ON;
SET VERIFY OFF;
SET PAGES 0;
SET HEAD OFF;
 
spool d:\dev\RESULT_STATS_INDEXES.TXT
/

DECLARE
  actualSchemaName   VARCHAR2(50);
BEGIN
  -- Récupération du schéma actuel
  select user into actualSchemaName from dual;
begin
for c in (
	select *
	from user_tables
	where last_analyzed < sysdate - 1
      and TABLE_NAME not like 'A_%'
      and TABLE_NAME not like 'ACTU%'
      and TABLE_NAME not like 'D4_%'
      and TABLE_NAME not like 'BATCH_%'
      and TABLE_NAME not like 'INFO%'
      and TABLE_NAME not like 'SAS_%'
      and TABLE_NAME not like 'SG85_%'
      and TABLE_NAME not like 'TT%'
	)
loop

dbms_output.put_line(TO_DATE(SYSDATE,'DD/MM/YYYY HH24:MI:SS') || ' > Table : ' || c.table_name);

dbms_stats.gather_table_stats(
			ownname => actualSchemaName,
			tabname => c.table_name,
			cascade => TRUE,
			estimate_percent => dbms_stats.auto_sample_size,
			method_opt => 'for all indexed columns size auto');

end loop; 
end;
end;
/



-- Script permettant de générer le calcul des statistiques pour l'ensemble des tables d'un schema
SET ECHO OFF;
SET FEEDBACK OFF;
SET SERVEROUTPUT ON;
SET VERIFY OFF;
SET PAGES 0;
SET HEAD OFF;
 
DECLARE
  actualSchemaName   VARCHAR2(50);
BEGIN
  -- Récupération du schéma actuel
  select user into actualSchemaName from dual; 
begin
for c in (
	select * 
	from user_indexes
	where last_analyzed < sysdate - 1
      and TABLE_NAME not like 'A_%' 
      and TABLE_NAME not like 'ACTU%' 
      and TABLE_NAME not like 'D4_%'
      and TABLE_NAME not like 'BATCH_%'
      and TABLE_NAME not like 'INFO%'
      and TABLE_NAME not like 'SAS_%'
      and TABLE_NAME not like 'SG85_%'
      and TABLE_NAME not like 'TT%'
	) 
loop 

dbms_output.put_line(TO_DATE(SYSDATE,'DD/MM/YYYY HH24:MI:SS') || ' > Index : ' || c.table_name);

execute immediate 'ALTER INDEX '||actualSchemaName||'.'||c.index_name||' rebuild online nologging';

end loop; 
end;
end;
/

spool off;


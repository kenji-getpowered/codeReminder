-- This line allows to generate an id (raw type) but to let a noticeable mark for searching and id purpose.
--  SELECT
--       substr(concat('KROK_2016.1',sys_guid()),0,32) ? avec ça tu n’as plus à t’embeter à gérer les id
--     FROM
--       dual
    

INSERT
INTO
  BATCH_COMMAND
  (
    ID,
    TYPE,
    PARAMETERS,
    STATUT,
    DATE_PLANIFIEE,
    DATE_DEBUT,
    DATE_FIN,
    ID_STATUT_BATCH,
    ID_STATUT_BATCH_COMMANDER
  )
  VALUES
  (
    (
      SELECT
        substr(concat('KROK_2016.1',sys_guid()),0,32) ? avec ça tu n’as plus à t’embeter à gérer les id
      FROM
        dual
    )
    ,
    'InfoCentre_Actuariat',null,'PENDING',
    to_date('19/01/16','DD/MM/RR'),null,null,null,null);

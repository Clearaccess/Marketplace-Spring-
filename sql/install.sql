SPOOL .\init.log

@@createTables.sql
@@createSeq.sql
@@createProcUsers.sql
@@createProcBids.sql
@@createProcItems.sql
@@fillData.sql

SPOOL OFF
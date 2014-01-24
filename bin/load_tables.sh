#! /bin/bash

data_dir = $1

-- load customer data
./psql.sh -t customer -d '|' 2 3 -h C_CUSTKEY,C_NAME,C_ADDRESS,C_NATIONKEY,C_PHONE,C_ACCTBAL,C_MKTSEGMENT,C_COMMENT,C_EMPTY localhost $data_dir/customer.csv

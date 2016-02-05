select Key as KeyName, Value as KeyValue,
CASE nvl(Value,0) WHEN '0' THEN 'skip' ELSE 'Yes' END as ConfigKeyEnabled, 
CASE nvl(Value,0) WHEN '0' THEN 'Yes' ELSE 'skip' END as ConfigKeyDisabled, 
CASE nvl(Value,0) WHEN '0' THEN 'OFF' ELSE 'ON' END as ConfigKeyStatus
from configuration_element 
where lower(key) = lower ('exchange.sso.method')
and config_identifier in (
  select identifier from exchange_configuration 
  where (LOWER(component) like  LOWER('%employer%')) and exchange_id = (
    select exchange_identifier 
    from exchange 
    where (LOWER(Exchange_Name)= LOWER('automation') OR LOWER(Subdomain)= LOWER('automation'))
  )
)
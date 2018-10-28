#Where To Use Externalizable ?

The default java serialization is not efficient. It you serialize a bloated objected having lots of attributes and properties, you do not wish to serialize for any reason 

 you get heavy object to process and send more bytes over network which may be costly on some cases.
 
 (e.g. There are  100 attributes But i want only 5 attributes as to Serializable),


# Externalizable

Externalizable extends Serializable. 

Externalizable interface contains two methods writeExternal() and readExternal() which implementing classes MUST override

methods then first preference is given to these methods over default serialization mechanism provided by JVM.

A public no-arg constructor is required while using Externalizable interface.

## writeExternal()
method is used to provide the logic for serialization
							 i.e. writing the fields of class into bytes. You are free to store only those fields which you want back after reading the serialized object back. Ignore rest of the field.

##readExternal()
method must read the values in the same sequence and with the same types as were written by writeExternal().

## Request
`http://localhost:8080/rest/serialize` - 
POST request with user JSON eg 


	`[{"yourName":"karthik",
	"mobileNumber":9696969696,
	"yourGirlFriendName":"karthik",
	"yourGirlFriendNameMobileNumber":9143143143
	}]`


## Responce
- `http://localhost:8080/rest/deserialize` 

- GET request which returns user JSON eg 

	`[ {
        "yourName": "karthik",
        "mobileNumber": 9696969696,
        "yourGirlFriendName": "karthik",
        "yourGirlFriendMobileNumber": null
    }]`


# swagger-jersey-problem

This project is only to show a bug/problem between swagger and jersey.

## Description

There are six test launchers to show the problem:

* <code>net.bogdoll.CommonPackageWithPackages</code>
* <code>net.bogdoll.CommonPackageWithRegister</code>
* <code>net.bogdoll.SeparatePackagesBWithPackages</code>
* <code>net.bogdoll.SeparatePackagesBWithRegister</code>
* <code>net.bogdoll.SeparatePackagesCWithPackages</code>
* <code>net.bogdoll.SeparatePackagesCWithRegister</code>

All six projects have the following in common:

I'm using Grizzly/Jersey/Swagger, I have a REST-Resource called BaseResource 
which contains in one class the implementation and the annotation for REST 
and Swagger.
There is another REST-Resource called DataResource which is split into a 
interface which contains the REST and Swagger annotation and a implementation 
of the interface which only contains the implementation.

The  two examples starting with CommonPackage* have those two REST-Resources
in the same package, the difference is how the resources are registered with Jersey.

The two examples starting with SeparatePackagesB* have again two REST-Resources,
but this time the implementation of the DataResource resides in an extra package.

The two examples starting with SeparatePackagesC* have again two REST-Resoruces,
but this time the interface of the DataResource resides in an extra package.

Three of the examples ends with *WithPackages to denote how the resources
are registered at Jersey, in this case <code>packages(String)</code> command is used.

The other three examples ends with *WithRegisater to denote that <code>register(FullQuallifiedClassName)</code> was used.

The result is that there is no difference in the results of the different prefices. The result is only determined if I use packages or register
or register the Resources.

If I use packages the /data REST call fails, but Swagger /api-docs REST call returns a correct string.
If I use register all the REST calls succeed, but the Swaggter /api-docs REST call returns only the description for /base and not for /data.



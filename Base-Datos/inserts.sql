use POLIFOOD;
drop procedure sp_insertarUsuarioDatos;


delimiter //
create procedure sp_insertarUsuarioDatos(in p_correoInstitucional varchar(50), in p_telefonoCelular varchar(10),
									in p_noBoleta varchar(10), in p_contrasenia varchar(10),
                                    in p_nombre varchar(50), 
                                    in p_aPaterno varchar(50),in p_aMaterno varchar(50))
begin
	declare v_id int;
	insert into Usuarios(correo,celular,boleta,contrasenia)
    values(p_correoInstitucional, p_telefonoCelular, p_noBoleta, p_contrasenia);
    select id into v_id from Usuarios where correo =  p_correoInstitucional;
    insert into Personales(nombre,paterno,materno,id_usuario_fk)
    values(p_nombre,p_aPaterno,p_aMaterno,v_id);
    select Usuarios.correo, Usuarios.celular, Usuarios.contrasenia, Usuarios.boleta,									
    Personales.nombre, Personales.paterno, Personales.materno from Usuarios inner join Personales on Usuarios.id = Personales.id_usuario_fk where (Usuarios.correo = p_correoInstitucional);
end
// delimiter ;

drop procedure sp_insertarProducto
delimiter //
create procedure sp_insertarProducto(in p_correoInstitucional varchar(50), in p_nombreProducto varchar(50), in p_precio float,
									 in p_descripcion varchar(70))
begin
	declare v_id int;
    select id into v_id from Usuarios where correo = p_correoInstitucional;
    insert into Datos_producto(nombre_producto,precio,descripcion,id_usuario_fk)
    values(p_nombreProducto,p_precio,p_descripcion,v_id);
    select Datos_Producto.nombre_producto, Datos_Producto.precio, Datos_Producto.descripcion from  Datos_producto where  id_datos = 
    (select max(id_datos) from Datos_producto inner join Usuarios on Usuarios.id = id_usuario_fk where correo = p_correoInstitucional and nombre_producto = p_nombreProducto);
end
// delimiter ;


delimiter //
create procedure sp_listarProductosPropios(in p_correoInstitucional varchar(50), in p_contrasenia varchar(20))
begin
	select Datos_Producto.nombre_producto, Datos_Producto.precio, Datos_Producto.descripcion from Datos_Producto inner join Usuarios on  Datos_Producto.id_usuario_fk = Usuarios.id  where correo = p_correoInstitucional
	and contrasenia = p_contrasenia;
end
// delimiter ;

delimiter //
create procedure sp_listarProductos()
begin
	select Datos_Producto.nombre_producto, Datos_Producto.precio, Datos_Producto.descripcion from Datos_Producto;
end
// delimiter ;
drop procedure sp_insertarCompra
delimiter //
create procedure sp_insertarCompra(in p_cantidad int, in p_nombreProducto varchar(50))
begin
	declare v_id_compra int;
    declare v_precio float;
    select precio into v_precio from Datos_Producto where Datos_Producto.nombre_producto = "torta";
    select id_datos into v_id_compra from Datos_Producto where Datos_Producto.nombre_producto = p_nombreProducto;
    insert into Ordenes(id_datos_fk, cantidad) 
    values(v_id_compra,p_cantidad);
    select cantidad from Ordenes where id_compra=last_insert_id();
end
// delimiter ;

delimiter //
create procedure sp_loginUsuario(in p_correoInstitucional varchar(50), in p_contrasenia varchar(20))
begin 
	select Usuarios.correo, Usuarios.contrasenia from Usuarios where (correo = p_correoInstitucional and contrasenia = p_contrasenia);
end
// delimiter ;

select * from Datos_Producto;
select * from Usuarios;
select * from Personales;
select * from Ordenes;

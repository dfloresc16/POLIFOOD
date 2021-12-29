use POLIFOOD;
drop procedure sp_insertarUsuario;

-- INSERT

-- Tabla Usuario

delimiter //
create procedure sp_insertarUsuario(in p_correoInstitucional varchar(50), in p_telefonoCelular varchar(10),
									in p_noBoleta varchar(10), in p_contrasenia varchar(10))
begin
    insert into Usuarios(correoInstitucional,telefonoCelular,noBoleta,contrasenia)
    values(p_correoInstitucional, p_telefonoCelular, p_noBoleta, p_contrasenia);
end// delimiter ;


-- Tabla Datos Personales
delimiter //
create procedure sp_insertarDatosPersonales( in p_nombre varchar(50), 
                                    in p_aPaterno varchar(50),in p_aMaterno varchar(50),
                                    in p_correoInstitucional varchar(50))
begin
	declare v_id int;
	select id into v_id from Usuarios where correo =  p_correoInstitucional;
    insert into Personales(nombre,paterno,materno,id_usuario_fk)
    values(p_nombre,p_aPaterno,p_aMaterno,v_id);
    select * from Personales where id_usuario_fk=(select id from Usuarios where correo = p_correoInstitucional );
end// delimiter ;


-- Tabla Productos Usuario
delimiter //
create procedure sp_insertarProductoUsuario(in p_correo varchar(50))
begin
	declare v_idUsuario int; 
    select id into v_idUsuario from Usuarios where correo = p_correo;
    insert into Productos(id_usuario_fk)
    values(v_idUsuario);
        select * from  Productos where id_usuario_fk=(select id from Usuarios where correo = p_correo );
end// delimiter ;


-- Tabla Datos Producto
delimiter //
create procedure sp_insertarDatosProducto(in p_nombreProducto varchar(20), in p_precio float,
										  in p_descripcion varchar(50), in p_correoInstitucional varchar(50))
begin
	declare v_idProducto int;
    select max(id_producto) into v_idProducto from Productos where  id_usuario_fk = (select id from Usuarios where correo = p_correoInstitucional);
    insert into Datos_producto(nombre_producto,precio,descripcion,id_producto_fk)
    values(p_nombreProducto,p_precio,p_descripcion,v_idProducto);
    select * from  Datos_producto where  id_producto_fk= (select max(id_producto) from Productos where id_usuario_fk=(select id from Usuarios where correo = p_correoInstitucional)  );
end
//delimiter ;


-- Tabla Orden de compra 
delimiter //
create procedure sp_insertarCompra(in p_correo varchar(50), in p_cantidad int, in p_nombreProducto varchar(20))
begin
	declare v_idUsuario int;
    declare v_idProducto int;
    select id_producto into v_idProducto from Productos where id_producto = (select id_producto_fk from Datos_producto where nombre_producto = p_nombreProducto);
    select id into v_idUsuario from Usuarios where correo = p_correo;
	insert into Ordenes(cantidad,id_usuario_fk,id_producto_fk)
    values(p_cantidad,v_idUsuario,v_idProducto);
    select * from Ordenes where id_usuario_fk = 1 and id_compra = max(id_compra);
end
// delimiter ;


-- Tabla Ventas
delimiter //
create procedure sp_insertarVenta(in p_mensaje varchar(250), in p_nombreProducto varchar(20),
								  in p_correoInstitucional varchar(50))
begin
	declare v_idUsuario int;
    declare v_idCompra int;
    select idUsuario_fk into v_idUsuario from ProductosUsuario where idProducto = (select idProducto_fk from DatosProducto where nombreProducto = p_nombreProducto);
    select max(idCompra) into v_idCompra from OrdenesCompra where idUsuario_fk = (select id from Usuarios where correoInstitucional = p_correoInstitucional);
	insert into Ventas(idUsuario_fk,idCompra_fk,mensaje)
    values();
end
// delimiter ;

-- Tabla Solicitud Compra

delimiter //
create procedure sp_insertarSolicitud(in p_correoInstitucional varchar(50), in p_nombreProducto varchar(20), in p_mensaje varchar(250))
begin
	declare v_idCompra int;
    declare v_idProducto int;
    select idCompra into v_idCompra from OrdenesCompra where idUsuario_fk = (select id from Usuarios where correoInstitucional = p_correoInstitucional);
    select idProducto into v_idProducto from ProductosUsuario where idProducto = (select idProducto_fk DatosProducto where nombreProducto = p_nombreProducto);
    insert into SolucitudCompra(idProducto_fk, idCompra_fk, mensaje)
    values(v_idProducto,v_idCompra,p_mensaje);
end
// delimiter ;


-- DELETE 

-- Borrar Usuario por correo Institucional 
delimiter //
create procedure sp_borrarUsuario(in p_correoInstitucional varchar(50))
begin
	delete from Usuarios where correoInstitucional = p_correoInstitucional;
end
//delimiter ;

-- Borrar Producto con Id y correo institucional
delimiter // 
create procedure sp_borrarProducto(in p_idProducto int, in p_correoInsititucional varchar(50))
begin
     select Datos_producto.*,Productos.* from Productos inner join Datos_producto on id_producto =id_producto_fk where id_producto=p_idProducto;
     delete from Productos where id_producto= p_idProducto;
     delete from Datos_producto where id_producto_fk= p_idProducto;
end
// delimiter ; 


-- UPDATE

delimiter //
create procedure sp_ActualizarDatosPersonales(in _nombre varchar(50), 
                                    in _apellidoP varchar(50),in _apellidoM varchar(50),
                                    in _correoInstitucional varchar(26))
begin
	update DatosPersonales set nombre = _nombre, apellido_Paterno = _apellidoP, apellido_Materno = _apellidoM
    where correo_Institucional = _correoInstitucional;
end
//delimiter ;


-- SELECT


-- Buscar usuario por nombre
delimiter //
create procedure sp_buscarUsuario(in p_correo varchar(50))
begin
	-- select Usuarios.*,DatosPersonales.* from Usuarios, DatosPersonales where id = (select idUsuario_fk from DatosPersonales where nombre = p_nombre);
    -- select Usuarios.*,DatosPersonales.* from Usuarios inner join DatosPersonales on id=idUsuario_fk where Usuarios.correoInstitucional = p_correoInstitucional;
    select * from Usuarios where correo = p_correo;
    
end
//delimiter ;

-- Buscar productos por nombre
delimiter //
create procedure sp_buscarProducto(in p_nombreProducto varchar(20))
begin
	select DatosProducto.* from DatosProducto where nombreProducto = p_nombreProducto;
end


//delimiter ;